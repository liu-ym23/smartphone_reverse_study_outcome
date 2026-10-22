package kotlin.text;

import ai.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.WasExperimental;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.a;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\n\u001a\u0018\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a:\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001aE\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b!\u001a:\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010#\u001a\u00020\u0010*\u00020\u00022\u0006\u0010$\u001a\u00020\u0006\u001aD\u0010%\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010*\u001aD\u0010+\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010*\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a;\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b.\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u00100\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u00100\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\n\u00103\u001a\u00020\u0010*\u00020\u0002\u001a\r\u00104\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00105\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00106\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a \u00107\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00108\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00109\u001a\u00020:*\u00020\u0002H\u0086\u0002\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010<\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u0010<\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010=\u001a\b\u0012\u0004\u0012\u00020\r0>*\u00020\u0002\u001a\u0010\u0010?\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u0002\u001a\u0015\u0010A\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\f\u001a\u000f\u0010B\u001a\u00020\r*\u0004\u0018\u00010\rH\u0087\b\u001a\u001c\u0010C\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0014\u001a\u001c\u0010C\u001a\u00020\r*\u00020\r2\u0006\u0010D\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0014\u001a\u001c\u0010F\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0014\u001a\u001c\u0010F\u001a\u00020\r*\u00020\r2\u0006\u0010D\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0014\u001aG\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00010>*\u00020\u00022\u000e\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0I2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\bJ\u0010K\u001a=\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00010>*\u00020\u00022\u0006\u0010H\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bJ\u001a4\u0010L\u001a\u00020\u0010*\u00020\u00022\u0006\u0010M\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0012\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\r*\u00020\r2\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010Q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006\u001a\u0012\u0010Q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u0001\u001a\u001d\u0010Q\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010Q\u001a\u00020\r*\u00020\r2\u0006\u0010R\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010T\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010T\u001a\u00020\r*\u00020\r2\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a.\u0010V\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\b\u0010W\u001a\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u00020XH\u0087\bø\u0001\u0000\u001a\u001d\u0010V\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020\rH\u0087\b\u001a$\u0010[\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010[\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010_\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010_\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001d\u0010`\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020\rH\u0087\b\u001a)\u0010a\u001a\u00020\r*\u00020\r2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140XH\u0087\bø\u0001\u0000¢\u0006\u0002\bb\u001a)\u0010a\u001a\u00020\r*\u00020\r2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020XH\u0087\bø\u0001\u0000¢\u0006\u0002\bc\u001a\"\u0010d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0002\u001a\u001a\u0010d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0002\u001a%\u0010d\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010d\u001a\u00020\r*\u00020\r2\u0006\u0010R\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0002H\u0087\b\u001a=\u0010e\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\u0012\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0I\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010f\u001a0\u0010e\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\n\u0010H\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a/\u0010e\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\u0006\u0010U\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bg\u001a%\u0010e\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a=\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0>*\u00020\u00022\u0012\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0I\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010i\u001a0\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0>*\u00020\u00022\n\u0010H\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a%\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0>*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a\u001c\u0010j\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010j\u001a\u00020\u0010*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a$\u0010j\u001a\u00020\u0010*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010k\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u0001\u001a\u001d\u0010k\u001a\u00020\u0002*\u00020\r2\u0006\u0010l\u001a\u00020\u00062\u0006\u0010m\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010n\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010n\u001a\u00020\r*\u00020\u00022\u0006\u0010R\u001a\u00020\u0001\u001a\u0012\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010R\u001a\u00020\u0001\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010r\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010r\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\f\u0010s\u001a\u00020\u0010*\u00020\rH\u0007\u001a\u0013\u0010t\u001a\u0004\u0018\u00010\u0010*\u00020\rH\u0007¢\u0006\u0002\u0010u\u001a\n\u0010v\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010v\u001a\u00020\u0002*\u00020\u00022\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010v\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010v\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010v\u001a\u00020\r*\u00020\r2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010v\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010x\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010x\u001a\u00020\u0002*\u00020\u00022\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010x\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010x\u001a\u00020\r*\u00020\r2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010y\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010y\u001a\u00020\u0002*\u00020\u00022\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010y\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010y\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010y\u001a\u00020\r*\u00020\r2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010y\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006z"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "requireNonNegativeLimit", "", "limit", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isBlank", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
@SourceDebugExtension({"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1499:1\n80#1,22:1500\n114#1,5:1522\n131#1,5:1527\n80#1,22:1532\n108#1:1554\n80#1,22:1555\n114#1,5:1577\n125#1:1582\n114#1,5:1583\n131#1,5:1588\n142#1:1593\n131#1,5:1594\n80#1,22:1599\n114#1,5:1621\n131#1,5:1626\n1069#2,2:1631\n12591#3,2:1633\n12591#3,2:1635\n295#4,2:1637\n295#4,2:1639\n1557#4:1642\n1628#4,3:1643\n1557#4:1646\n1628#4,3:1647\n1#5:1641\n*S KotlinDebug\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n108#1:1500,22\n125#1:1522,5\n142#1:1527,5\n147#1:1532,22\n152#1:1554\n152#1:1555,22\n157#1:1577,5\n162#1:1582\n162#1:1583,5\n167#1:1588,5\n172#1:1593\n172#1:1594,5\n177#1:1599,22\n188#1:1621,5\n199#1:1626,5\n312#1:1631,2\n952#1:1633,2\n976#1:1635,2\n1015#1:1637,2\n1021#1:1639,2\n1321#1:1642\n1321#1:1643,3\n1346#1:1646\n1346#1:1647,3\n*E\n"})
class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public StringsKt__StringsKt() {
    }

    public static final /* synthetic */ Pair access$findAnyOf(CharSequence r5, Collection r10, int r11, boolean r12, boolean r13) {
        return findAnyOf$StringsKt__StringsKt(r5, r10, r11, r12, r13);
    }

    public static final String commonPrefixWith(CharSequence r5, CharSequence r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "other");
        int r12 = Math.min(r5.length(), r10.length());
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L7;
        if (CharsKt__CharKt.equals(r5.charAt(r13), r10.charAt(r13), r11) == false) goto L7;
        r13 = r13 + 1;
    L7:
        int r14 = r13 - 1;
        if (hasSurrogatePairAt(r5, r14) == false) goto L10;
    L11:
        r13 = r13 - 1;
    L13:
        return r5.subSequence(0, r13).toString();
    L10:
        if (hasSurrogatePairAt(r10, r14) == false) goto L13;
        goto L11
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence r5, CharSequence r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return commonPrefixWith(r5, r10, r11);
    }

    public static final String commonSuffixWith(CharSequence r10, CharSequence r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r5 = r10.length();
        int r13 = r11.length();
        int r14 = Math.min(r5, r13);
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        if (CharsKt__CharKt.equals(r10.charAt((r5 - r15) - 1), r11.charAt((r13 - r15) - 1), r12) == false) goto L8;
        r15 = r15 + 1;
    L8:
        if (hasSurrogatePairAt(r10, (r5 - r15) - 1) == false) goto L10;
    L11:
        r15 = r15 - 1;
    L13:
        return r10.subSequence(r5 - r15, r5).toString();
    L10:
        if (hasSurrogatePairAt(r11, (r13 - r15) - 1) == false) goto L13;
        goto L11
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence r5, CharSequence r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return commonSuffixWith(r5, r10, r11);
    }

    public static boolean contains(CharSequence r11, CharSequence r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "other");
        if ((r12 instanceof String) == false) goto L8;
        if (indexOf$default(r11, (String) r12, 0, r13, 2, null) >= 0) goto L11;
        return false;
    L11:
        return true;
    L8:
        if (indexOf$StringsKt__StringsKt$default(r11, r12, 0, r11.length(), r13, false, 16, null) >= 0) goto L11;
        return false;
    }

    public static /* synthetic */ boolean contains$default(CharSequence r5, CharSequence r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return contains(r5, r10, r11);
    }

    public static final boolean contentEqualsIgnoreCaseImpl(CharSequence r10, CharSequence r11) {
        if ((r10 instanceof String) == true) goto L5;
    L8:
        if (r10 != r11) goto L11;
        return true;
    L11:
        if (r10 == null) goto L23;
        if (r11 == null) goto L23;
        if (r10.length() != r11.length()) goto L23;
        int r5 = r10.length();
        int r12 = 0;
    L17:
        if (r12 >= r5) goto L22;
        if (CharsKt__CharKt.equals(r10.charAt(r12), r11.charAt(r12), true) == false) goto L20;
        r12 = r12 + 1;
        goto L17
    L20:
        return false;
    L22:
        return true;
    L23:
        return false;
    L5:
        if ((r11 instanceof String) == false) goto L8;
        return StringsKt__StringsJVMKt.equals((String) r10, (String) r11, true);
    }

    public static final boolean contentEqualsImpl(CharSequence r10, CharSequence r11) {
        if ((r10 instanceof String) == false) goto L9;
        if ((r11 instanceof String) == false) goto L9;
        return Intrinsics.areEqual(r10, r11);
    L9:
        if (r10 != r11) goto L12;
        return true;
    L12:
        if (r10 == null) goto L24;
        if (r11 == null) goto L24;
        if (r10.length() != r11.length()) goto L24;
        int r5 = r10.length();
        int r12 = 0;
    L18:
        if (r12 >= r5) goto L23;
        if (r10.charAt(r12) != r11.charAt(r12)) goto L21;
        r12 = r12 + 1;
        goto L18
    L21:
        return false;
    L23:
        return true;
    L24:
        return false;
    }

    public static final boolean endsWith(CharSequence r5, char r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.length() > 0) goto L5;
    L7:
        return false;
    L5:
        if (CharsKt__CharKt.equals(r5.charAt(getLastIndex(r5)), r10, r11) == false) goto L7;
        return true;
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence r5, char r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return endsWith(r5, r10, r11);
    }

    public static final Pair<Integer, String> findAnyOf(CharSequence r5, Collection<String> r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "strings");
        return findAnyOf$StringsKt__StringsKt(r5, r10, r11, r12, false);
    }

    private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence r10, Collection<String> r11, int r12, boolean r13, boolean r14) {
        if (r13 == true) goto L15;
        if (r11.size() != 1) goto L15;
        String r15 = (String) CollectionsKt.single(r11);
        if (r14 == true) goto L9;
        int r16 = indexOf$default(r10, r15, r12, false, 4, null);
    L10:
        if (r16 >= 0) goto L13;
        return null;
    L13:
        return TuplesKt.to(Integer.valueOf(r16), r15);
    L9:
        r16 = lastIndexOf$default(r10, r15, r12, false, 4, null);
    L15:
        if (r14 == true) goto L17;
        IntProgression r17 = new IntRange(RangesKt.coerceAtLeast(r12, 0), r10.length());
    L19:
        if ((r10 instanceof String) == false) goto L38;
        int r18 = r17.getFirst();
        int r5 = r17.getLast();
        int r19 = r17.getStep();
        if (r19 <= 0) goto L23;
        if (r18 > r5) goto L23;
    L25:
        Iterator<T> r20 = r11.iterator();
    L27:
        if (r20.hasNext() == false) goto L31;
        Object r21 = r20.next();
        String r22 = (String) r21;
        if (StringsKt__StringsJVMKt.regionMatches(r22, 0, (String) r10, r18, r22.length(), r13) == false) goto L27;
    L32:
        String r23 = (String) r21;
        if (r23 != null) goto L35;
        if (r18 == r5) goto L56;
        r18 = r18 + r19;
    L56:
        return null;
    L35:
        return TuplesKt.to(Integer.valueOf(r18), r23);
    L31:
        r21 = null;
    L23:
        if (r19 >= 0) goto L56;
        if (r5 > r18) goto L56;
    L38:
        int r110 = r17.getFirst();
        int r24 = r17.getLast();
        int r111 = r17.getStep();
        if (r111 <= 0) goto L41;
        if (r110 > r24) goto L41;
    L43:
        Iterator<T> r25 = r11.iterator();
    L45:
        if (r25.hasNext() == false) goto L49;
        Object r26 = r25.next();
        String r27 = (String) r26;
        if (regionMatchesImpl(r27, 0, r10, r110, r27.length(), r13) == false) goto L45;
    L50:
        String r28 = (String) r26;
        if (r28 != null) goto L53;
        if (r110 == r24) goto L56;
        r110 = r110 + r111;
        goto L43
    L53:
        return TuplesKt.to(Integer.valueOf(r110), r28);
    L49:
        r26 = null;
    L41:
        if (r111 >= 0) goto L56;
        if (r24 > r110) goto L56;
    L17:
        r17 = RangesKt.downTo(RangesKt.coerceAtMost(r12, getLastIndex(r10)), 0);
        goto L19
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence r5, Collection r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = false;
    L9:
        return findAnyOf(r5, r10, r11, r12);
    }

    public static final Pair<Integer, String> findLastAnyOf(CharSequence r5, Collection<String> r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "strings");
        return findAnyOf$StringsKt__StringsKt(r5, r10, r11, r12, true);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence r5, Collection r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = getLastIndex(r5);
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = false;
    L9:
        return findLastAnyOf(r5, r10, r11, r12);
    }

    public static IntRange getIndices(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new IntRange(0, r5.length() - 1);
    }

    public static int getLastIndex(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(CharSequence r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 >= 0) goto L5;
    L11:
        return false;
    L5:
        if (r10 > (r5.length() - 2)) goto L11;
        if (Character.isHighSurrogate(r5.charAt(r10)) == false) goto L11;
        if (Character.isLowSurrogate(r5.charAt(r10 + 1)) == false) goto L11;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R ifBlank(C r5, Function0<? extends R> r10) {
        Intrinsics.checkNotNullParameter(r10, "defaultValue");
        if (isBlank(r5) == true) goto L5;
        return r5;
    L5:
        return r10.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R ifEmpty(C r5, Function0<? extends R> r10) {
        Intrinsics.checkNotNullParameter(r10, "defaultValue");
        if (r5.length() == 0) goto L5;
        return r5;
    L5:
        return r10.invoke();
    }

    public static final int indexOf(CharSequence r5, char r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r12 == true) goto L9;
        if ((r5 instanceof String) == false) goto L9;
        return ((String) r5).indexOf(r10, r11);
    L9:
        return indexOfAny(r5, new char[]{r10}, r11, r12);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence r10, CharSequence r11, int r12, int r13, boolean r14, boolean r15) {
        if (r15 == true) goto L5;
        IntProgression r16 = new IntRange(RangesKt.coerceAtLeast(r12, 0), RangesKt.coerceAtMost(r13, r10.length()));
    L7:
        if ((r10 instanceof String) == true) goto L9;
    L20:
        int r17 = r16.getFirst();
        int r18 = r16.getLast();
        int r19 = r16.getStep();
        if (r19 <= 0) goto L23;
        if (r17 > r18) goto L23;
    L25:
        int r5 = r17;
        if (regionMatchesImpl(r11, 0, r10, r5, r11.length(), r14) == true) goto L27;
        if (r17 == r18) goto L42;
        r17 = r17 + r19;
        goto L25
    L42:
        return -1;
    L27:
        return r17;
    L23:
        if (r19 >= 0) goto L39;
        if (r18 <= r17) goto L25;
        return -1;
    L39:
        return -1;
    L9:
        if ((r11 instanceof String) == false) goto L20;
        int r20 = r16.getFirst();
        int r21 = r16.getLast();
        int r110 = r16.getStep();
        if (r110 <= 0) goto L13;
        if (r20 > r21) goto L13;
    L15:
        int r22 = r20;
        if (StringsKt__StringsJVMKt.regionMatches((String) r11, 0, (String) r10, r22, ((String) r11).length(), r14) == true) goto L17;
        if (r20 == r21) goto L41;
        r20 = r20 + r110;
        goto L15
    L41:
        return -1;
    L17:
        return r20;
    L13:
        if (r110 >= 0) goto L30;
        if (r21 <= r20) goto L15;
        return -1;
    L30:
        return -1;
    L5:
        r16 = RangesKt.downTo(RangesKt.coerceAtMost(r12, getLastIndex(r10)), RangesKt.coerceAtLeast(r13, 0));
        goto L7
    }

    public static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence r10, CharSequence r11, int r12, int r13, boolean r14, boolean r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = false;
    L6:
        return indexOf$StringsKt__StringsKt(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ int indexOf$default(CharSequence r5, char r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = false;
    L9:
        return indexOf(r5, r10, r11, r12);
    }

    public static final int indexOfAny(CharSequence r10, char[] r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "chars");
        if (r13 == false) goto L5;
    L10:
        int r14 = RangesKt.coerceAtLeast(r12, 0);
        int r5 = getLastIndex(r10);
        if (r14 > r5) goto L20;
    L12:
        char r15 = r10.charAt(r14);
        int r16 = r11.length;
        int r17 = 0;
    L13:
        if (r17 >= r16) goto L18;
        if (CharsKt__CharKt.equals(r11[r17], r15, r13) == true) goto L16;
        r17 = r17 + 1;
        goto L13
    L16:
        return r14;
    L18:
        if (r14 == r5) goto L25;
        r14 = r14 + 1;
        goto L12
    L25:
        return -1;
    L20:
        return -1;
    L5:
        if (r11.length != 1) goto L10;
        if ((r10 instanceof String) == false) goto L10;
        return ((String) r10).indexOf(ArraysKt.single(r11), r12);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence r5, char[] r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = false;
    L9:
        return indexOfAny(r5, r10, r11, r12);
    }

    public static boolean isBlank(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r10 = 0;
    L4:
        if (r10 >= r5.length()) goto L9;
        if (CharsKt__CharJVMKt.isWhitespace(r5.charAt(r10)) == false) goto L13;
        r10 = r10 + 1;
        goto L4
    L13:
        return false;
    L9:
        return true;
    }

    @InlineOnly
    private static final boolean isEmpty(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.length() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @InlineOnly
    private static final boolean isNotBlank(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return !isBlank(r5);
    }

    @InlineOnly
    private static final boolean isNotEmpty(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @InlineOnly
    private static final boolean isNullOrBlank(CharSequence r5) {
        if (r5 != null) goto L4;
    L7:
        return true;
    L4:
        if (isBlank(r5) == true) goto L7;
        return false;
    }

    @InlineOnly
    private static final boolean isNullOrEmpty(CharSequence r5) {
        if (r5 != null) goto L4;
    L7:
        return true;
    L4:
        if (r5.length() == 0) goto L7;
        return false;
    }

    public static final CharIterator iterator(final CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new AnonymousClass1(r5);
    }

    public static final int lastIndexOf(CharSequence r5, char r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r12 == true) goto L9;
        if ((r5 instanceof String) == false) goto L9;
        return ((String) r5).lastIndexOf(r10, r11);
    L9:
        return lastIndexOfAny(r5, new char[]{r10}, r11, r12);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence r5, char r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = getLastIndex(r5);
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = false;
    L9:
        return lastIndexOf(r5, r10, r11, r12);
    }

    public static final int lastIndexOfAny(CharSequence r5, char[] r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "chars");
        if (r12 == false) goto L5;
    L10:
        int r13 = RangesKt.coerceAtMost(r11, getLastIndex(r5));
    L12:
        if ((-1) >= r13) goto L20;
        char r14 = r5.charAt(r13);
        int r15 = r10.length;
        int r16 = 0;
    L14:
        if (r16 >= r15) goto L19;
        if (CharsKt__CharKt.equals(r10[r16], r14, r12) == true) goto L17;
        r16 = r16 + 1;
        goto L14
    L17:
        return r13;
    L19:
        r13 = r13 - 1;
        goto L12
    L20:
        return -1;
    L5:
        if (r10.length != 1) goto L10;
        if ((r5 instanceof String) == false) goto L10;
        return ((String) r5).lastIndexOf(ArraysKt.single(r10), r11);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence r5, char[] r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = getLastIndex(r5);
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = false;
    L9:
        return lastIndexOfAny(r5, r10, r11, r12);
    }

    public static final Sequence<String> lineSequence(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return splitToSequence$default(r10, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static List<String> lines(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return SequencesKt.toList(lineSequence(r5));
    }

    @InlineOnly
    private static final boolean matches(CharSequence r5, Regex r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "regex");
        return r10.matches(r5);
    }

    @InlineOnly
    private static final String orEmpty(String r5) {
        if (r5 != null) goto L5;
        return "";
    L5:
        return r5;
    }

    public static final CharSequence padEnd(CharSequence r5, int r10, char r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 < 0) goto L15;
        if (r10 <= r5.length()) goto L7;
        StringBuilder r12 = new StringBuilder(r10);
        r12.append(r5);
        int r13 = r10 - r5.length();
        int r14 = 1;
        if (1 > r13) goto L13;
    L10:
        r12.append(r11);
        if (r14 == r13) goto L13;
        r14 = r14 + 1;
    L13:
        return r12;
    L7:
        return r5.subSequence(0, r5.length());
    L15:
        throw new IllegalArgumentException(j0.h(r10, "Desired length ", " is less than zero."));
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence r5, int r10, char r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = ' ';
    L6:
        return padEnd(r5, r10, r11);
    }

    public static final CharSequence padStart(CharSequence r5, int r10, char r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 < 0) goto L16;
        if (r10 <= r5.length()) goto L7;
        StringBuilder r12 = new StringBuilder(r10);
        int r13 = r10 - r5.length();
        int r14 = 1;
        if (1 > r13) goto L13;
    L10:
        r12.append(r11);
        if (r14 == r13) goto L13;
        r14 = r14 + 1;
    L13:
        r12.append(r5);
        return r12;
    L7:
        return r5.subSequence(0, r5.length());
    L16:
        throw new IllegalArgumentException(j0.h(r10, "Desired length ", " is less than zero."));
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence r5, int r10, char r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = ' ';
    L6:
        return padStart(r5, r10, r11);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence r5, final char[] r10, int r11, final boolean r12, int r13) {
        requireNonNegativeLimit(r13);
        return new DelimitedRangesSequence(r5, r11, r13, new StringsKt__StringsKt$rangesDelimitedBy$1(r10, r12));
    }

    public static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence r5, char[] r10, int r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = false;
    L9:
        if ((r14 & 8) == 0) goto L12;
        r13 = 0;
    L12:
        return rangesDelimitedBy$StringsKt__StringsKt(r5, r10, r11, r12, r13);
    }

    public static final boolean regionMatchesImpl(CharSequence r5, int r10, CharSequence r11, int r12, int r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        if (r12 < 0) goto L18;
        if (r10 < 0) goto L18;
        if (r10 > (r5.length() - r13)) goto L18;
        if (r12 > (r11.length() - r13)) goto L18;
        int r15 = 0;
    L11:
        if (r15 >= r13) goto L16;
        if (CharsKt__CharKt.equals(r5.charAt(r10 + r15), r11.charAt(r12 + r15), r14) == false) goto L14;
        r15 = r15 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }

    public static final CharSequence removePrefix(CharSequence r5, CharSequence r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "prefix");
        if (startsWith$default(r5, r10, false, 2, null) == false) goto L7;
        return r5.subSequence(r10.length(), r5.length());
    L7:
        return r5.subSequence(0, r5.length());
    }

    public static final CharSequence removeRange(CharSequence r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r11 < r10) goto L11;
        if (r11 == r10) goto L7;
        StringBuilder r12 = new StringBuilder(r5.length() - (r11 - r10));
        r12.append(r5, 0, r10);
        r12.append(r5, r11, r5.length());
        return r12;
    L7:
        return r5.subSequence(0, r5.length());
    L11:
        throw new IndexOutOfBoundsException("End index (" + r11 + ") is less than start index (" + r10 + ").");
    }

    public static final CharSequence removeSuffix(CharSequence r5, CharSequence r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "suffix");
        if (endsWith$default(r5, r10, false, 2, null) == false) goto L7;
        return r5.subSequence(0, r5.length() - r10.length());
    L7:
        return r5.subSequence(0, r5.length());
    }

    public static final CharSequence removeSurrounding(CharSequence r5, CharSequence r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "prefix");
        Intrinsics.checkNotNullParameter(r11, "suffix");
        int r12 = r5.length();
        int r13 = r10.length();
        if (r12 < (r11.length() + r13)) goto L11;
        if (startsWith$default(r5, r10, false, 2, null) == false) goto L11;
        if (endsWith$default(r5, r11, false, 2, null) == false) goto L11;
        return r5.subSequence(r10.length(), r5.length() - r11.length());
    L11:
        return r5.subSequence(0, r5.length());
    }

    @InlineOnly
    private static final String replace(CharSequence r5, Regex r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "regex");
        Intrinsics.checkNotNullParameter(r11, "replacement");
        return r10.replace(r5, r11);
    }

    public static final String replaceAfter(String r10, char r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = indexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, r14 + 1, r10.length(), r12).toString();
    }

    public static /* synthetic */ String replaceAfter$default(String r5, char r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = r5;
    L6:
        return replaceAfter(r5, r10, r11, r12);
    }

    public static final String replaceAfterLast(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r5 = lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r5 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, r11.length() + r5, r10.length(), r12).toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String r5, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = r5;
    L6:
        return replaceAfterLast(r5, r10, r11, r12);
    }

    public static final String replaceBefore(String r10, char r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = indexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, 0, r14, r12).toString();
    }

    public static /* synthetic */ String replaceBefore$default(String r5, char r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = r5;
    L6:
        return replaceBefore(r5, r10, r11, r12);
    }

    public static final String replaceBeforeLast(String r10, char r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, 0, r14, r12).toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String r5, char r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = r5;
    L6:
        return replaceBeforeLast(r5, r10, r11, r12);
    }

    @InlineOnly
    private static final String replaceFirst(CharSequence r5, Regex r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "regex");
        Intrinsics.checkNotNullParameter(r11, "replacement");
        return r10.replaceFirst(r5, r11);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithChar")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String replaceFirstCharWithChar(String r5, Function1<? super Character, Character> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "transform");
        if (r5.length() > 0) goto L5;
        return r5;
    L5:
        return r10.invoke(Character.valueOf(r5.charAt(0))).charValue() + r5.substring(1);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithCharSequence")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String replaceFirstCharWithCharSequence(String r5, Function1<? super Character, ? extends CharSequence> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "transform");
        if (r5.length() > 0) goto L5;
        return r5;
    L5:
        return r10.invoke(Character.valueOf(r5.charAt(0))) + r5.substring(1);
    }

    public static final CharSequence replaceRange(CharSequence r5, int r10, int r11, CharSequence r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        if (r11 < r10) goto L7;
        StringBuilder r13 = new StringBuilder();
        r13.append(r5, 0, r10);
        r13.append(r12);
        r13.append(r5, r11, r5.length());
        return r13;
    L7:
        throw new IndexOutOfBoundsException("End index (" + r11 + ") is less than start index (" + r10 + ").");
    }

    public static final void requireNonNegativeLimit(int r5) {
        if (r5 < 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(j0.g(r5, "Limit must be non-negative, but was ").toString());
    }

    public static final List<String> split(CharSequence r10, String[] r11, boolean r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiters");
        if (r11.length != 1) goto L9;
        String r5 = r11[0];
        if (r5.length() == 0) goto L9;
        return split$StringsKt__StringsKt(r10, r5, r12, r13);
    L9:
        Iterable r14 = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(r10, r11, 0, r12, r13, 2, null));
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator r16 = r14.iterator();
    L11:
        if (r16.hasNext() == false) goto L13;
        r15.add(substring(r10, (IntRange) r16.next()));
        goto L11
    L13:
        return r15;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence r10, String r11, boolean r12, int r13) {
        requireNonNegativeLimit(r13);
        int r5 = 0;
        int r14 = indexOf(r10, r11, 0, r12);
        if (r14 == (-1)) goto L23;
        if (r13 == 1) goto L23;
        if (r13 <= 0) goto L9;
        boolean r15 = true;
    L10:
        int r16 = 10;
        if (r15 == false) goto L13;
        r16 = RangesKt.coerceAtMost(r13, 10);
    L13:
        ArrayList r17 = new ArrayList(r16);
    L14:
        r17.add(r10.subSequence(r5, r14).toString());
        r5 = r11.length() + r14;
        if (r15 == true) goto L17;
    L18:
        r14 = indexOf(r10, r11, r5, r12);
        if (r14 != (-1)) goto L14;
    L20:
        r17.add(r10.subSequence(r5, r10.length()).toString());
        return r17;
    L17:
        if (r17.size() == (r13 - 1)) goto L20;
    L9:
        r15 = false;
    L23:
        return CollectionsKt.listOf(r10.toString());
    }

    public static /* synthetic */ List split$default(CharSequence r5, String[] r10, boolean r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        return split(r5, r10, r11, r12);
    }

    public static final Sequence<String> splitToSequence(final CharSequence r10, String[] r11, boolean r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(r10, r11, 0, r12, r13, 2, null), new C02731(r10));
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence r5, String[] r10, boolean r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        return splitToSequence(r5, r10, r11, r12);
    }

    public static final boolean startsWith(CharSequence r5, char r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.length() > 0) goto L5;
        return false;
    L5:
        if (CharsKt__CharKt.equals(r5.charAt(0), r10, r11) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r5, char r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return startsWith(r5, r10, r11);
    }

    public static final CharSequence subSequence(CharSequence r5, IntRange r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "range");
        return r5.subSequence(r10.getStart().intValue(), r10.getEndInclusive().intValue() + 1);
    }

    public static final String substring(String r5, IntRange r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "range");
        return r5.substring(r10.getStart().intValue(), r10.getEndInclusive().intValue() + 1);
    }

    public static /* synthetic */ String substring$default(CharSequence r5, int r10, int r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = r5.length();
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.subSequence(r10, r11).toString();
    }

    public static final String substringAfter(String r10, char r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = indexOf$default(r10, r11, 0, false, 6, null);
        if (r13 != (-1)) goto L6;
        return r12;
    L6:
        return r10.substring(r13 + 1, r10.length());
    }

    public static /* synthetic */ String substringAfter$default(String r5, char r10, String r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = r5;
    L6:
        return substringAfter(r5, r10, r11);
    }

    public static String substringAfterLast(String r10, char r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r13 != (-1)) goto L6;
        return r12;
    L6:
        return r10.substring(r13 + 1, r10.length());
    }

    public static /* synthetic */ String substringAfterLast$default(String r5, char r10, String r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = r5;
    L6:
        return substringAfterLast(r5, r10, r11);
    }

    public static final String substringBefore(String r10, char r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = indexOf$default(r10, r11, 0, false, 6, null);
        if (r13 != (-1)) goto L6;
        return r12;
    L6:
        return r10.substring(0, r13);
    }

    public static /* synthetic */ String substringBefore$default(String r5, char r10, String r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = r5;
    L6:
        return substringBefore(r5, r10, r11);
    }

    public static String substringBeforeLast(String r10, char r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r13 != (-1)) goto L6;
        return r12;
    L6:
        return r10.substring(0, r13);
    }

    public static /* synthetic */ String substringBeforeLast$default(String r5, char r10, String r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = r5;
    L6:
        return substringBeforeLast(r5, r10, r11);
    }

    @SinceKotlin(version = "1.5")
    public static final boolean toBooleanStrict(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Intrinsics.areEqual(r5, "true") == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r5, "false") == false) goto L10;
        return false;
    L10:
        throw new IllegalArgumentException(j0.C("The string doesn't represent a boolean value: ", r5));
    }

    @SinceKotlin(version = "1.5")
    public static Boolean toBooleanStrictOrNull(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Intrinsics.areEqual(r5, "true") == false) goto L6;
        return Boolean.TRUE;
    L6:
        if (Intrinsics.areEqual(r5, "false") == true) goto L11;
        return null;
    L11:
        return Boolean.FALSE;
    }

    public static final CharSequence trim(CharSequence r5, Function1<? super Character, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        int r11 = r5.length() - 1;
        int r12 = 0;
        boolean r13 = false;
    L3:
        if (r12 > r11) goto L16;
        if (r13 == true) goto L6;
        int r14 = r12;
    L7:
        boolean r15 = ((Boolean) a.b(r5, r14, r10)).booleanValue();
        if (r13 == false) goto L9;
        if (r15 == false) goto L16;
        r11 = r11 - 1;
        goto L3
    L9:
        if (r15 == false) goto L10;
        r12 = r12 + 1;
        goto L3
    L10:
        r13 = true;
        goto L3
    L6:
        r14 = r11;
    L16:
        return r5.subSequence(r12, r11 + 1);
    }

    public static final CharSequence trimEnd(CharSequence r5, Function1<? super Character, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        int r11 = r5.length() - 1;
        if (r11 < 0) goto L11;
    L4:
        int r12 = r11 - 1;
        if (((Boolean) a.b(r5, r11, r10)).booleanValue() == false) goto L7;
        if (r12 < 0) goto L15;
        r11 = r12;
        goto L4
    L15:
        return "";
    L7:
        return r5.subSequence(0, r11 + 1);
    L11:
        return "";
    }

    public static final CharSequence trimStart(CharSequence r5, Function1<? super Character, Boolean> r10) {
        int r11 = a.a(r5, "<this>", r10, "predicate");
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (((Boolean) a.b(r5, r12, r10)).booleanValue() == false) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        return r5.subSequence(r12, r5.length());
    L9:
        return "";
    }

    public static /* synthetic */ boolean contains$default(CharSequence r5, char r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return contains(r5, r10, r11);
    }

    public static final boolean endsWith(CharSequence r10, CharSequence r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "suffix");
        if (r12 == true) goto L11;
        if ((r10 instanceof String) == false) goto L11;
        if ((r11 instanceof String) == false) goto L11;
        return StringsKt__StringsJVMKt.endsWith$default((String) r10, (String) r11, false, 2, null);
    L11:
        return regionMatchesImpl(r10, r10.length() - r11.length(), r11, 0, r11.length(), r12);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence r5, CharSequence r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return endsWith(r5, r10, r11);
    }

    public static /* synthetic */ int indexOf$default(CharSequence r5, String r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = false;
    L9:
        return indexOf(r5, r10, r11, r12);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence r5, Collection r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = false;
    L9:
        return indexOfAny(r5, r10, r11, r12);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence r5, String r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = getLastIndex(r5);
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = false;
    L9:
        return lastIndexOf(r5, r10, r11, r12);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence r5, Collection r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = getLastIndex(r5);
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = false;
    L9:
        return lastIndexOfAny(r5, r10, r11, r12);
    }

    public static /* synthetic */ String padEnd$default(String r5, int r10, char r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = ' ';
    L6:
        return padEnd(r5, r10, r11);
    }

    public static /* synthetic */ String padStart$default(String r5, int r10, char r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = ' ';
    L6:
        return padStart(r5, r10, r11);
    }

    public static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence r5, String[] r10, int r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = false;
    L9:
        if ((r14 & 8) == 0) goto L12;
        r13 = 0;
    L12:
        return rangesDelimitedBy$StringsKt__StringsKt(r5, r10, r11, r12, r13);
    }

    @InlineOnly
    private static final String replace(CharSequence r5, Regex r10, Function1<? super MatchResult, ? extends CharSequence> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "regex");
        Intrinsics.checkNotNullParameter(r11, "transform");
        return r10.replace(r5, r11);
    }

    public static /* synthetic */ String replaceAfter$default(String r5, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = r5;
    L6:
        return replaceAfter(r5, r10, r11, r12);
    }

    public static /* synthetic */ String replaceAfterLast$default(String r5, char r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = r5;
    L6:
        return replaceAfterLast(r5, r10, r11, r12);
    }

    public static /* synthetic */ String replaceBefore$default(String r5, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = r5;
    L6:
        return replaceBefore(r5, r10, r11, r12);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String r5, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = r5;
    L6:
        return replaceBeforeLast(r5, r10, r11, r12);
    }

    public static /* synthetic */ List split$default(CharSequence r5, char[] r10, boolean r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        return split(r5, r10, r11, r12);
    }

    public static final Sequence<String> splitToSequence(final CharSequence r10, char[] r11, boolean r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(r10, r11, 0, r12, r13, 2, null), new AnonymousClass2(r10));
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence r5, char[] r10, boolean r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        return splitToSequence(r5, r10, r11, r12);
    }

    public static final boolean startsWith(CharSequence r10, CharSequence r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        if (r12 == true) goto L11;
        if ((r10 instanceof String) == false) goto L11;
        if ((r11 instanceof String) == false) goto L11;
        return StringsKt__StringsJVMKt.startsWith$default((String) r10, (String) r11, false, 2, null);
    L11:
        return regionMatchesImpl(r10, 0, r11, 0, r11.length(), r12);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r5, CharSequence r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return startsWith(r5, r10, r11);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    @InlineOnly
    private static final CharSequence subSequence(String r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.subSequence(r10, r11);
    }

    @InlineOnly
    private static final String substring(CharSequence r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.subSequence(r10, r11).toString();
    }

    public static /* synthetic */ String substringAfter$default(String r5, String r10, String r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = r5;
    L6:
        return substringAfter(r5, r10, r11);
    }

    public static /* synthetic */ String substringAfterLast$default(String r5, String r10, String r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = r5;
    L6:
        return substringAfterLast(r5, r10, r11);
    }

    public static /* synthetic */ String substringBefore$default(String r5, String r10, String r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = r5;
    L6:
        return substringBefore(r5, r10, r11);
    }

    public static /* synthetic */ String substringBeforeLast$default(String r5, String r10, String r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = r5;
    L6:
        return substringBeforeLast(r5, r10, r11);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence r5, String[] r10, int r11, final boolean r12, int r13) {
        requireNonNegativeLimit(r13);
        final List r14 = ArraysKt.asList(r10);
        return new DelimitedRangesSequence(r5, r11, r13, new StringsKt__StringsKt$rangesDelimitedBy$2(r14, r12));
    }

    public static final String replaceAfter(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r5 = indexOf$default(r10, r11, 0, false, 6, null);
        if (r5 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, r11.length() + r5, r10.length(), r12).toString();
    }

    public static final String replaceAfterLast(String r10, char r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, r14 + 1, r10.length(), r12).toString();
    }

    public static final String replaceBefore(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = indexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, 0, r14, r12).toString();
    }

    public static final String replaceBeforeLast(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        Intrinsics.checkNotNullParameter(r13, "missingDelimiterValue");
        int r14 = lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r14 != (-1)) goto L6;
        return r13;
    L6:
        return replaceRange(r10, 0, r14, r12).toString();
    }

    public static /* synthetic */ List split$default(CharSequence r5, Regex r10, int r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "regex");
        return r10.split(r5, r11);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final Sequence<String> splitToSequence(CharSequence r5, Regex r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "regex");
        return r10.splitToSequence(r5, r11);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence r5, Regex r10, int r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "regex");
        return r10.splitToSequence(r5, r11);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r5, CharSequence r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = false;
    L6:
        return startsWith(r5, r10, r11, r12);
    }

    public static final String substring(CharSequence r5, IntRange r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "range");
        return r5.subSequence(r10.getStart().intValue(), r10.getEndInclusive().intValue() + 1).toString();
    }

    public static String substringAfter(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r5 = indexOf$default(r10, r11, 0, false, 6, null);
        if (r5 != (-1)) goto L6;
        return r12;
    L6:
        return r10.substring(r11.length() + r5, r10.length());
    }

    public static final String substringAfterLast(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r5 = lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r5 != (-1)) goto L6;
        return r12;
    L6:
        return r10.substring(r11.length() + r5, r10.length());
    }

    public static String substringBefore(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = indexOf$default(r10, r11, 0, false, 6, null);
        if (r13 != (-1)) goto L6;
        return r12;
    L6:
        return r10.substring(0, r13);
    }

    public static String substringBeforeLast(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiter");
        Intrinsics.checkNotNullParameter(r12, "missingDelimiterValue");
        int r13 = lastIndexOf$default(r10, r11, 0, false, 6, null);
        if (r13 != (-1)) goto L6;
        return r12;
    L6:
        return r10.substring(0, r13);
    }

    public static final boolean contains(CharSequence r10, char r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (indexOf$default(r10, r11, 0, r12, 2, null) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final int indexOf(CharSequence r10, String r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "string");
        if (r13 == true) goto L9;
        if ((r10 instanceof String) == false) goto L9;
        return ((String) r10).indexOf(r11, r12);
    L9:
        return indexOf$StringsKt__StringsKt$default(r10, r11, r12, r10.length(), r13, false, 16, null);
    }

    public static final int lastIndexOf(CharSequence r10, String r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "string");
        if (r13 == true) goto L9;
        if ((r10 instanceof String) == false) goto L9;
        return ((String) r10).lastIndexOf(r11, r12);
    L9:
        return indexOf$StringsKt__StringsKt(r10, r11, r12, 0, r13, true);
    }

    public static String removePrefix(String r5, CharSequence r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "prefix");
        if (startsWith$default(r5, r10, false, 2, null) == true) goto L5;
        return r5;
    L5:
        return r5.substring(r10.length());
    }

    public static String removeSuffix(String r5, CharSequence r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "suffix");
        if (endsWith$default(r5, r10, false, 2, null) == true) goto L5;
        return r5;
    L5:
        return r5.substring(0, r5.length() - r10.length());
    }

    public static final String removeSurrounding(String r5, CharSequence r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "prefix");
        Intrinsics.checkNotNullParameter(r11, "suffix");
        int r12 = r5.length();
        int r13 = r10.length();
        if (r12 >= (r11.length() + r13)) goto L5;
        return r5;
    L5:
        if (startsWith$default(r5, r10, false, 2, null) == true) goto L7;
        return r5;
    L7:
        if (endsWith$default(r5, r11, false, 2, null) == true) goto L9;
        return r5;
    L9:
        return r5.substring(r10.length(), r5.length() - r11.length());
    }

    @InlineOnly
    private static final boolean contains(CharSequence r5, Regex r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "regex");
        return r10.containsMatchIn(r5);
    }

    public static final boolean startsWith(CharSequence r10, CharSequence r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        if (r13 == true) goto L11;
        if ((r10 instanceof String) == false) goto L11;
        if ((r11 instanceof String) == false) goto L11;
        return StringsKt__StringsJVMKt.startsWith$default((String) r10, (String) r11, r12, false, 4, null);
    L11:
        return regionMatchesImpl(r10, r12, r11, 0, r11.length(), r13);
    }

    @InlineOnly
    private static final String removeRange(String r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return removeRange(r5, r10, r11).toString();
    }

    public static final CharSequence removeSurrounding(CharSequence r5, CharSequence r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "delimiter");
        return removeSurrounding(r5, r10, r10);
    }

    @InlineOnly
    private static final String replaceRange(String r5, int r10, int r11, CharSequence r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r12, "replacement");
        return replaceRange(r5, r10, r11, r12).toString();
    }

    public static final CharSequence removeRange(CharSequence r5, IntRange r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "range");
        return removeRange(r5, r10.getStart().intValue(), androidx.room.jarjarred.org.antlr.runtime.a.h(1, r10));
    }

    public static String removeSurrounding(String r5, CharSequence r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "delimiter");
        return removeSurrounding(r5, r10, r10);
    }

    public static final CharSequence replaceRange(CharSequence r5, IntRange r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "range");
        Intrinsics.checkNotNullParameter(r11, "replacement");
        return replaceRange(r5, r10.getStart().intValue(), androidx.room.jarjarred.org.antlr.runtime.a.h(1, r10), r11);
    }

    public static final int indexOfAny(CharSequence r5, Collection<String> r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "strings");
        Pair<Integer, String> r13 = findAnyOf$StringsKt__StringsKt(r5, r10, r11, r12, false);
        if (r13 != null) goto L7;
        return -1;
    L7:
        return r13.getFirst().intValue();
    }

    public static final int lastIndexOfAny(CharSequence r5, Collection<String> r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "strings");
        Pair<Integer, String> r13 = findAnyOf$StringsKt__StringsKt(r5, r10, r11, r12, true);
        if (r13 != null) goto L7;
        return -1;
    L7:
        return r13.getFirst().intValue();
    }

    @InlineOnly
    private static final String trim(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return trim(r5).toString();
    }

    public static final String trim(String r5, Function1<? super Character, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        int r11 = r5.length() - 1;
        int r12 = 0;
        boolean r13 = false;
    L3:
        if (r12 > r11) goto L16;
        if (r13 == true) goto L6;
        int r14 = r12;
    L7:
        boolean r15 = r10.invoke(Character.valueOf(r5.charAt(r14))).booleanValue();
        if (r13 == false) goto L9;
        if (r15 == false) goto L16;
        r11 = r11 - 1;
        goto L3
    L9:
        if (r15 == false) goto L10;
        r12 = r12 + 1;
        goto L3
    L10:
        r13 = true;
        goto L3
    L6:
        r14 = r11;
    L16:
        return r5.subSequence(r12, r11 + 1).toString();
    }

    @InlineOnly
    private static final String trimEnd(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return trimEnd(r5).toString();
    }

    public static final String trimEnd(String r5, Function1<? super Character, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        int r11 = r5.length() - 1;
        if (r11 < 0) goto L10;
    L4:
        int r12 = r11 - 1;
        if (r10.invoke(Character.valueOf(r5.charAt(r11))).booleanValue() == false) goto L6;
        if (r12 < 0) goto L10;
        r11 = r12;
        goto L4
    L6:
        CharSequence r13 = r5.subSequence(0, r11 + 1);
    L12:
        return r13.toString();
    L10:
        r13 = "";
        goto L12
    }

    public static final List<String> split(CharSequence r10, char[] r11, boolean r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiters");
        if (r11.length == 1) goto L5;
        Iterable r14 = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(r10, r11, 0, r12, r13, 2, null));
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        r15.add(substring(r10, (IntRange) r16.next()));
        goto L8
    L10:
        return r15;
    L5:
        return split$StringsKt__StringsKt(r10, String.valueOf(r11[0]), r12, r13);
    }

    @InlineOnly
    private static final String removeRange(String r5, IntRange r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "range");
        return removeRange(r5, r10).toString();
    }

    @InlineOnly
    private static final String replaceRange(String r5, IntRange r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "range");
        Intrinsics.checkNotNullParameter(r11, "replacement");
        return replaceRange(r5, r10, r11).toString();
    }

    @InlineOnly
    private static final String trimStart(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return trimStart(r5).toString();
    }

    public static final CharSequence trim(CharSequence r5, char... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "chars");
        int r11 = r5.length() - 1;
        int r12 = 0;
        boolean r13 = false;
    L3:
        if (r12 > r11) goto L16;
        if (r13 == true) goto L6;
        int r14 = r12;
    L7:
        boolean r15 = ArraysKt.contains(r10, r5.charAt(r14));
        if (r13 == false) goto L9;
        if (r15 == false) goto L16;
        r11 = r11 - 1;
        goto L3
    L9:
        if (r15 == false) goto L10;
        r12 = r12 + 1;
        goto L3
    L10:
        r13 = true;
        goto L3
    L6:
        r14 = r11;
    L16:
        return r5.subSequence(r12, r11 + 1);
    }

    public static final String trimStart(String r5, Function1<? super Character, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (r10.invoke(Character.valueOf(r5.charAt(r12))).booleanValue() == false) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        CharSequence r13 = r5.subSequence(r12, r5.length());
    L10:
        return r13.toString();
    L8:
        r13 = "";
        goto L10
    }

    public static final String padEnd(String r5, int r10, char r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return padEnd(r5, r10, r11).toString();
    }

    public static String padStart(String r5, int r10, char r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return padStart(r5, r10, r11).toString();
    }

    public static final CharSequence trimEnd(CharSequence r5, char... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "chars");
        int r11 = r5.length() - 1;
        if (r11 < 0) goto L10;
    L4:
        int r12 = r11 - 1;
        if (ArraysKt.contains(r10, r5.charAt(r11)) == false) goto L14;
        if (r12 < 0) goto L10;
        r11 = r12;
        goto L4
    L14:
        return r5.subSequence(0, r11 + 1);
    L10:
        return "";
    }

    public static String trim(String r5, char... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "chars");
        int r11 = r5.length() - 1;
        int r12 = 0;
        boolean r13 = false;
    L3:
        if (r12 > r11) goto L16;
        if (r13 == true) goto L6;
        int r14 = r12;
    L7:
        boolean r15 = ArraysKt.contains(r10, r5.charAt(r14));
        if (r13 == false) goto L9;
        if (r15 == false) goto L16;
        r11 = r11 - 1;
        goto L3
    L9:
        if (r15 == false) goto L10;
        r12 = r12 + 1;
        goto L3
    L10:
        r13 = true;
        goto L3
    L6:
        r14 = r11;
    L16:
        return r5.subSequence(r12, r11 + 1).toString();
    }

    public static final CharSequence trimStart(CharSequence r5, char... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "chars");
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (ArraysKt.contains(r10, r5.charAt(r12)) == false) goto L12;
        r12 = r12 + 1;
        goto L3
    L12:
        return r5.subSequence(r12, r5.length());
    L8:
        return "";
    }

    @InlineOnly
    private static final List<String> split(CharSequence r5, Regex r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "regex");
        return r10.split(r5, r11);
    }

    public static String trimEnd(String r5, char... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "chars");
        int r11 = r5.length() - 1;
        if (r11 < 0) goto L10;
    L4:
        int r12 = r11 - 1;
        if (ArraysKt.contains(r10, r5.charAt(r11)) == false) goto L6;
        if (r12 < 0) goto L10;
        r11 = r12;
        goto L4
    L6:
        CharSequence r13 = r5.subSequence(0, r11 + 1);
    L12:
        return r13.toString();
    L10:
        r13 = "";
        goto L12
    }

    public static CharSequence trim(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r10 = r5.length() - 1;
        int r11 = 0;
        boolean r12 = false;
    L3:
        if (r11 > r10) goto L16;
        if (r12 == true) goto L6;
        int r13 = r11;
    L7:
        boolean r14 = CharsKt__CharJVMKt.isWhitespace(r5.charAt(r13));
        if (r12 == false) goto L9;
        if (r14 == false) goto L16;
        r10 = r10 - 1;
        goto L3
    L9:
        if (r14 == false) goto L10;
        r11 = r11 + 1;
        goto L3
    L10:
        r12 = true;
        goto L3
    L6:
        r13 = r10;
    L16:
        return r5.subSequence(r11, r10 + 1);
    }

    public static final String trimStart(String r5, char... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "chars");
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (ArraysKt.contains(r10, r5.charAt(r12)) == false) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        CharSequence r13 = r5.subSequence(r12, r5.length());
    L10:
        return r13.toString();
    L8:
        r13 = "";
        goto L10
    }

    public static final CharSequence trimEnd(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r10 = r5.length() - 1;
        if (r10 < 0) goto L10;
    L4:
        int r11 = r10 - 1;
        if (CharsKt__CharJVMKt.isWhitespace(r5.charAt(r10)) == false) goto L14;
        if (r11 < 0) goto L10;
        r10 = r11;
        goto L4
    L14:
        return r5.subSequence(0, r10 + 1);
    L10:
        return "";
    }

    public static final CharSequence trimStart(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r10 = r5.length();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (CharsKt__CharJVMKt.isWhitespace(r5.charAt(r11)) == false) goto L12;
        r11 = r11 + 1;
        goto L3
    L12:
        return r5.subSequence(r11, r5.length());
    L8:
        return "";
    }
}
