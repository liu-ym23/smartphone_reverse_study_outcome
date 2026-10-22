package kotlin.text;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\n\u001a\u0018\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a:\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001aE\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b!\u001a:\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010#\u001a\u00020\u0010*\u00020\u00022\u0006\u0010$\u001a\u00020\u0006\u001aD\u0010%\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010*\u001aD\u0010+\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010*\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a;\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b.\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u00100\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u00100\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\n\u00103\u001a\u00020\u0010*\u00020\u0002\u001a\r\u00104\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00105\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00106\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a \u00107\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00108\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00109\u001a\u00020:*\u00020\u0002H\u0086\u0002\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010<\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u0010<\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010=\u001a\b\u0012\u0004\u0012\u00020\r0>*\u00020\u0002\u001a\u0010\u0010?\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u0002\u001a\u0015\u0010A\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\f\u001a\u000f\u0010B\u001a\u00020\r*\u0004\u0018\u00010\rH\u0087\b\u001a\u001c\u0010C\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0014\u001a\u001c\u0010C\u001a\u00020\r*\u00020\r2\u0006\u0010D\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0014\u001a\u001c\u0010F\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0014\u001a\u001c\u0010F\u001a\u00020\r*\u00020\r2\u0006\u0010D\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0014\u001aG\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00010>*\u00020\u00022\u000e\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0I2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\bJ\u0010K\u001a=\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00010>*\u00020\u00022\u0006\u0010H\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bJ\u001a4\u0010L\u001a\u00020\u0010*\u00020\u00022\u0006\u0010M\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0012\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\r*\u00020\r2\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010Q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006\u001a\u0012\u0010Q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u0001\u001a\u001d\u0010Q\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010Q\u001a\u00020\r*\u00020\r2\u0006\u0010R\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010T\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010T\u001a\u00020\r*\u00020\r2\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a.\u0010V\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\b\u0010W\u001a\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u00020XH\u0087\bø\u0001\u0000\u001a\u001d\u0010V\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020\rH\u0087\b\u001a$\u0010[\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010[\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010_\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a$\u0010_\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001d\u0010`\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020\rH\u0087\b\u001a)\u0010a\u001a\u00020\r*\u00020\r2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140XH\u0087\bø\u0001\u0000¢\u0006\u0002\bb\u001a)\u0010a\u001a\u00020\r*\u00020\r2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020XH\u0087\bø\u0001\u0000¢\u0006\u0002\bc\u001a\"\u0010d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0002\u001a\u001a\u0010d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0002\u001a%\u0010d\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010d\u001a\u00020\r*\u00020\r2\u0006\u0010R\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0002H\u0087\b\u001a=\u0010e\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\u0012\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0I\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010f\u001a0\u0010e\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\n\u0010H\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a/\u0010e\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\u0006\u0010U\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bg\u001a%\u0010e\u001a\b\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a=\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0>*\u00020\u00022\u0012\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0I\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010i\u001a0\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0>*\u00020\u00022\n\u0010H\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a%\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0>*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a\u001c\u0010j\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010j\u001a\u00020\u0010*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a$\u0010j\u001a\u00020\u0010*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010k\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u0001\u001a\u001d\u0010k\u001a\u00020\u0002*\u00020\r2\u0006\u0010l\u001a\u00020\u00062\u0006\u0010m\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010n\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010n\u001a\u00020\r*\u00020\u00022\u0006\u0010R\u001a\u00020\u0001\u001a\u0012\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010R\u001a\u00020\u0001\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010r\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\b\b\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010r\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\\\u001a\u00020\r\u001a\f\u0010s\u001a\u00020\u0010*\u00020\rH\u0007\u001a\u0013\u0010t\u001a\u0004\u0018\u00010\u0010*\u00020\rH\u0007¢\u0006\u0002\u0010u\u001a\n\u0010v\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010v\u001a\u00020\u0002*\u00020\u00022\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010v\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010v\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010v\u001a\u00020\r*\u00020\r2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010v\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010x\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010x\u001a\u00020\u0002*\u00020\u00022\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010x\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010x\u001a\u00020\r*\u00020\r2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010y\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010y\u001a\u00020\u0002*\u00020\u00022\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010y\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010y\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010y\u001a\u00020\r*\u00020\r2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\bø\u0001\u0000\u001a\u0016\u0010y\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006z"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "requireNonNegativeLimit", "", "limit", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", TypedValues.Custom.S_STRING, "indexOfAny", "chars", "", "isBlank", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", XSDatatype.FACET_LENGTH, "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", CommonConsts.APM_INNER_EVENT_COST_START, "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public StringsKt__StringsKt() {
    }

    public static final /* synthetic */ Pair access$findAnyOf(CharSequence r2, Collection r3, int r4, boolean r5, boolean r6) {
        return findAnyOf$StringsKt__StringsKt((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    public static final String commonPrefixWith(CharSequence r5, CharSequence r6, boolean r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "other");
        int r0 = Math.min(r8.length(), r9.length());
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L7;
        if (CharsKt.equals(r8.charAt(r2), r9.charAt(r2), r7) == false) goto L7;
        r2 = r2 + 1;
    L7:
        int r10 = r2 - 1;
        if (StringsKt.hasSurrogatePairAt(r8, r10) == false) goto L10;
    L11:
        r2 = r2 - 1;
    L13:
        return r8.subSequence(0, r2).toString();
    L10:
        if (StringsKt.hasSurrogatePairAt(r9, r10) == false) goto L13;
        goto L11
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence r1, CharSequence r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return StringsKt.commonPrefixWith(r6, r7, r3);
    }

    public static final String commonSuffixWith(CharSequence r6, CharSequence r7, boolean r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "other");
        int r0 = r9.length();
        int r1 = r10.length();
        int r2 = Math.min(r0, r1);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        if (CharsKt.equals(r9.charAt((r0 - r3) - 1), r10.charAt((r1 - r3) - 1), r8) == false) goto L8;
        r3 = r3 + 1;
    L8:
        if (StringsKt.hasSurrogatePairAt(r9, (r0 - r3) - 1) == false) goto L10;
    L11:
        r3 = r3 - 1;
    L13:
        return r9.subSequence(r0 - r3, r0).toString();
    L10:
        if (StringsKt.hasSurrogatePairAt(r10, (r1 - r3) - 1) == false) goto L13;
        goto L11
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence r1, CharSequence r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return StringsKt.commonSuffixWith(r6, r7, r3);
    }

    public static final boolean contains(CharSequence r6, char r7, boolean r8) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (StringsKt.indexOf$default(r0, r7, 0, r8, 2, null) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean contains(CharSequence r10, CharSequence r11, boolean r12) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "other");
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L8;
        if (StringsKt.indexOf$default(r2, (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), 0, r12, 2, null) < 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (indexOf$StringsKt__StringsKt$default(r2, r3, 0, r2.length(), r12, false, 16, null) < 0) goto L11;
        return true;
    }

    private static final boolean contains(CharSequence r2, Regex r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "regex");
        return r3.containsMatchIn(r4);
    }

    public static /* synthetic */ boolean contains$default(CharSequence r1, char r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return StringsKt.contains(r6, r2, r3);
    }

    public static /* synthetic */ boolean contains$default(CharSequence r1, CharSequence r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return StringsKt.contains(r6, r7, r3);
    }

    public static final boolean contentEqualsIgnoreCaseImpl(CharSequence r6, CharSequence r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, String.class) == true) goto L5;
    L8:
        if (r8 != r9) goto L11;
        return true;
    L11:
        if (r8 == null) goto L23;
        if (r9 == null) goto L23;
        if (r8.length() != r9.length()) goto L23;
        int r1 = r8.length();
        int r3 = 0;
    L17:
        if (r3 >= r1) goto L22;
        if (CharsKt.equals(r8.charAt(r3), r9.charAt(r3), true) == false) goto L20;
        r3 = r3 + 1;
        goto L17
    L20:
        return false;
    L22:
        return true;
    L23:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L8;
        return StringsKt.equals((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin"), true);
    }

    public static final boolean contentEqualsImpl(CharSequence r6, CharSequence r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L9;
        return Intrinsics.areEqual(r8, r9);
    L9:
        if (r8 != r9) goto L12;
        return true;
    L12:
        if (r8 == null) goto L24;
        if (r9 == null) goto L24;
        if (r8.length() != r9.length()) goto L24;
        int r2 = r8.length();
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L23;
        if (r8.charAt(r3) != r9.charAt(r3)) goto L21;
        r3 = r3 + 1;
        goto L18
    L21:
        return false;
    L23:
        return true;
    L24:
        return false;
    }

    public static final boolean endsWith(CharSequence r2, char r3, boolean r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.length() > 0) goto L5;
    L7:
        return false;
    L5:
        if (CharsKt.equals(r5.charAt(StringsKt.getLastIndex(r5)), r3, r4) == false) goto L7;
        return true;
    }

    public static final boolean endsWith(CharSequence r8, CharSequence r9, boolean r10) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "suffix");
        if (r10 == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L11;
        return StringsKt.endsWith$default((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), false, 2, null);
    L11:
        return StringsKt.regionMatchesImpl(r2, r2.length() - r4.length(), r4, 0, r4.length(), r10);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence r1, char r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return StringsKt.endsWith(r6, r2, r3);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence r1, CharSequence r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return StringsKt.endsWith(r6, r7, r3);
    }

    public static final Pair<Integer, String> findAnyOf(CharSequence r2, Collection<String> r3, int r4, boolean r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "strings");
        return findAnyOf$StringsKt__StringsKt(r6, r7, r4, r5, false);
    }

    private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence r11, Collection<String> r12, int r13, boolean r14, boolean r15) {
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.wrapperContextForParams(r12, Collection.class, "com.obric.memorydata.plugin");
        if (r14 == true) goto L15;
        if (r17.size() != 1) goto L15;
        String r18 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.single((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");
        if (r15 == true) goto L9;
        int r19 = StringsKt.indexOf$default(r16, r18, r13, false, 4, null);
    L10:
        if (r19 >= 0) goto L13;
        return null;
    L13:
        return TuplesKt.to(Integer.valueOf(r19), r18);
    L9:
        r19 = StringsKt.lastIndexOf$default(r16, r18, r13, false, 4, null);
    L15:
        if (r15 == true) goto L17;
        IntProgression r110 = (IntProgression) ZeusTransformUtils.preCheckCast(new IntRange(RangesKt.coerceAtLeast(r13, 0), r16.length()), IntProgression.class, "com.obric.memorydata.plugin");
    L19:
        if (ZeusTransformUtils.instanceOf(r16, String.class) == false) goto L38;
        int r111 = r110.getFirst();
        int r2 = r110.getLast();
        int r112 = r110.getStep();
        if (r112 <= 0) goto L23;
        if (r111 > r2) goto L23;
    L25:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L27:
        if (r9.hasNext() == false) goto L31;
        Object r10 = r9.next();
        String r3 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");
        if (StringsKt.regionMatches(r3, 0, (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin"), r111, r3.length(), r14) == false) goto L27;
    L32:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L35;
        if (r111 == r2) goto L56;
        r111 = r111 + r112;
    L56:
        return null;
    L35:
        return TuplesKt.to(Integer.valueOf(r111), r4);
    L31:
        r10 = null;
    L23:
        if (r112 >= 0) goto L56;
        if (r2 > r111) goto L56;
    L38:
        int r113 = r110.getFirst();
        int r8 = r110.getLast();
        int r114 = r110.getStep();
        if (r114 <= 0) goto L41;
        if (r113 > r8) goto L41;
    L43:
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L45:
        if (r20.hasNext() == false) goto L49;
        Object r115 = r20.next();
        String r5 = (String) ZeusTransformUtils.preCheckCast(r115, String.class, "com.obric.memorydata.plugin");
        if (StringsKt.regionMatchesImpl((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), 0, r16, r113, r5.length(), r14) == false) goto L45;
    L50:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r115, String.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L53;
        if (r113 == r8) goto L56;
        r113 = r113 + r114;
        goto L43
    L53:
        return TuplesKt.to(Integer.valueOf(r113), r6);
    L49:
        r115 = null;
    L41:
        if (r114 >= 0) goto L56;
        if (r8 > r113) goto L56;
    L17:
        r110 = RangesKt.downTo(RangesKt.coerceAtMost(r13, StringsKt.getLastIndex(r16)), 0);
        goto L19
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence r1, Collection r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.findAnyOf(r7, r8, r3, r4);
    }

    public static final Pair<Integer, String> findLastAnyOf(CharSequence r2, Collection<String> r3, int r4, boolean r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "strings");
        return findAnyOf$StringsKt__StringsKt(r6, r7, r4, r5, true);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence r1, Collection r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = StringsKt.getLastIndex(r7);
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.findLastAnyOf(r7, r8, r3, r4);
    }

    public static final IntRange getIndices(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return new IntRange(0, r3.length() - 1);
    }

    public static final int getLastIndex(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r4 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L15;
        if (Character.isHighSurrogate(r5.charAt(r4)) == false) goto L15;
        if (Character.isLowSurrogate(r5.charAt(r4 + 1)) == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r4 > (r5.length() - 2)) goto L7;
        r2 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [R, java.lang.CharSequence] */
    private static final <C extends CharSequence & R, R> R ifBlank(C r2, Function0<? extends R> r3) {
        ?? r4 = (R) ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "defaultValue");
        if (StringsKt.isBlank(r4) == true) goto L5;
        return r4;
    L5:
        return (R) r5.invoke();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [R, java.lang.CharSequence] */
    private static final <C extends CharSequence & R, R> R ifEmpty(C r2, Function0<? extends R> r3) {
        ?? r4 = (R) ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "defaultValue");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return r4;
    L8:
        return (R) r5.invoke();
    L5:
        r0 = false;
        goto L6
    }

    public static final int indexOf(CharSequence r2, char r3, int r4, boolean r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (r5 == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L9;
        return ((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin")).indexOf(r3, r4);
    L9:
        return StringsKt.indexOfAny(r6, new char[]{r3}, r4, r5);
    }

    public static final int indexOf(CharSequence r10, String r11, int r12, boolean r13) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.Custom.S_STRING);
        if (r13 == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L9;
        return ((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin")).indexOf(r11, r12);
    L9:
        return indexOf$StringsKt__StringsKt$default(r2, (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), r12, r2.length(), r13, false, 16, null);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence r8, CharSequence r9, int r10, int r11, boolean r12, boolean r13) {
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if (r13 == true) goto L5;
        IntProgression r16 = (IntProgression) ZeusTransformUtils.preCheckCast(new IntRange(RangesKt.coerceAtLeast(r10, 0), RangesKt.coerceAtMost(r11, r14.length())), IntProgression.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r14, String.class) == true) goto L9;
    L20:
        int r17 = r16.getFirst();
        int r18 = r16.getLast();
        int r19 = r16.getStep();
        if (r19 <= 0) goto L23;
        if (r17 > r18) goto L23;
    L25:
        int r5 = r17;
        if (StringsKt.regionMatchesImpl(r15, 0, r14, r5, r15.length(), r12) == true) goto L27;
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
        if (ZeusTransformUtils.instanceOf(r15, String.class) == false) goto L20;
        int r110 = r16.getFirst();
        int r111 = r16.getLast();
        int r112 = r16.getStep();
        if (r112 <= 0) goto L13;
        if (r110 > r111) goto L13;
    L15:
        int r6 = r110;
        if (StringsKt.regionMatches((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin"), 0, (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin"), r6, r15.length(), r12) == true) goto L17;
        if (r110 == r111) goto L41;
        r110 = r110 + r112;
        goto L15
    L41:
        return -1;
    L17:
        return r110;
    L13:
        if (r112 >= 0) goto L30;
        if (r111 <= r110) goto L15;
        return -1;
    L30:
        return -1;
    L5:
        r16 = RangesKt.downTo(RangesKt.coerceAtMost(r10, StringsKt.getLastIndex(r14)), RangesKt.coerceAtLeast(r11, 0));
        goto L7
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence r7, CharSequence r8, int r9, int r10, boolean r11, boolean r12, int r13, Object r14) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r13 & 16) == 0) goto L6;
        r12 = false;
    L6:
        return indexOf$StringsKt__StringsKt(r1, r2, r9, r10, r11, r12);
    }

    public static /* synthetic */ int indexOf$default(CharSequence r1, char r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.indexOf(r7, r2, r3, r4);
    }

    public static /* synthetic */ int indexOf$default(CharSequence r1, String r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.indexOf(r7, r2, r3, r4);
    }

    public static final int indexOfAny(CharSequence r2, Collection<String> r3, int r4, boolean r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "strings");
        Pair<Integer, String> r8 = findAnyOf$StringsKt__StringsKt(r6, r7, r4, r5, false);
        if (r8 != null) goto L7;
        return -1;
    L7:
        return ((Number) ZeusTransformUtils.preCheckCast(r8.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int indexOfAny(CharSequence r7, char[] r8, int r9, boolean r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r8, "chars");
        if (r10 == false) goto L5;
    L10:
        int r12 = RangesKt.coerceAtLeast(r9, 0);
        int r2 = StringsKt.getLastIndex(r11);
        if (r12 > r2) goto L23;
    L12:
        char r3 = r11.charAt(r12);
        int r4 = r8.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L18;
        if (CharsKt.equals(r8[r5], r3, r10) == true) goto L16;
        r5 = r5 + 1;
        goto L13
    L16:
        boolean r6 = true;
    L19:
        if (r6 == true) goto L20;
        if (r12 == r2) goto L29;
        r12 = r12 + 1;
        goto L12
    L29:
        return -1;
    L20:
        return r12;
    L18:
        r6 = false;
        goto L19
    L23:
        return -1;
    L5:
        if (r8.length != 1) goto L10;
        if (ZeusTransformUtils.instanceOf(r11, String.class) == false) goto L10;
        return ((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin")).indexOf(ArraysKt.single(r8), r9);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence r1, Collection r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.indexOfAny(r7, r8, r3, r4);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence r1, char[] r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.indexOfAny(r7, r2, r3, r4);
    }

    public static final boolean isBlank(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        int r1 = 0;
    L4:
        if (r1 >= r4.length()) goto L9;
        if (CharsKt.isWhitespace(r4.charAt(r1)) == false) goto L13;
        r1 = r1 + 1;
        goto L4
    L13:
        return false;
    L9:
        return true;
    }

    private static final boolean isEmpty(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.length() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean isNotBlank(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return !StringsKt.isBlank(r3);
    }

    private static final boolean isNotEmpty(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean isNullOrBlank(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        return false;
    }

    private static final boolean isNullOrEmpty(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.length() == 0) goto L8;
        return false;
    }

    public static final CharIterator iterator(CharSequence r2) {
        final CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return (CharIterator) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), CharIterator.class, "com.obric.memorydata.plugin");
    }

    public static final int lastIndexOf(CharSequence r2, char r3, int r4, boolean r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (r5 == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L9;
        return ((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin")).lastIndexOf(r3, r4);
    L9:
        return StringsKt.lastIndexOfAny(r6, new char[]{r3}, r4, r5);
    }

    public static final int lastIndexOf(CharSequence r8, String r9, int r10, boolean r11) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r9, TypedValues.Custom.S_STRING);
        if (r11 == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L9;
        return ((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin")).lastIndexOf(r9, r10);
    L9:
        return indexOf$StringsKt__StringsKt(r2, (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), r10, 0, r11, true);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence r1, char r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = StringsKt.getLastIndex(r7);
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.lastIndexOf(r7, r2, r3, r4);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence r1, String r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = StringsKt.getLastIndex(r7);
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.lastIndexOf(r7, r2, r3, r4);
    }

    public static final int lastIndexOfAny(CharSequence r2, Collection<String> r3, int r4, boolean r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "strings");
        Pair<Integer, String> r8 = findAnyOf$StringsKt__StringsKt(r6, r7, r4, r5, true);
        if (r8 != null) goto L7;
        return -1;
    L7:
        return ((Number) ZeusTransformUtils.preCheckCast(r8.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int lastIndexOfAny(CharSequence r6, char[] r7, int r8, boolean r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r7, "chars");
        if (r9 == false) goto L5;
    L10:
        int r11 = RangesKt.coerceAtMost(r8, StringsKt.getLastIndex(r10));
    L12:
        if ((-1) >= r11) goto L22;
        char r1 = r10.charAt(r11);
        int r2 = r7.length;
        boolean r3 = false;
        int r4 = 0;
    L14:
        if (r4 >= r2) goto L19;
        if (CharsKt.equals(r7[r4], r1, r9) == true) goto L17;
        r4 = r4 + 1;
        goto L14
    L17:
        r3 = true;
    L19:
        if (r3 == true) goto L20;
        r11 = r11 - 1;
        goto L12
    L20:
        return r11;
    L22:
        return -1;
    L5:
        if (r7.length != 1) goto L10;
        if (ZeusTransformUtils.instanceOf(r10, String.class) == false) goto L10;
        return ((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin")).lastIndexOf(ArraysKt.single(r7), r8);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence r1, Collection r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = StringsKt.getLastIndex(r7);
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.lastIndexOfAny(r7, r8, r3, r4);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence r1, char[] r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = StringsKt.getLastIndex(r7);
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.lastIndexOfAny(r7, r2, r3, r4);
    }

    public static final Sequence<String> lineSequence(CharSequence r6) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "<this>");
        return StringsKt.splitToSequence$default(r0, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> lines(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return SequencesKt.toList(StringsKt.lineSequence(r3));
    }

    private static final boolean matches(CharSequence r2, Regex r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "regex");
        return r3.matches(r4);
    }

    private static final String orEmpty(String r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0;
    }

    public static final CharSequence padEnd(CharSequence r2, int r3, char r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r3 < 0) goto L16;
        if (r3 <= r5.length()) goto L7;
        StringBuilder r0 = new StringBuilder(r3);
        r0.append(r5);
        int r6 = r3 - r5.length();
        int r7 = 1;
        if (1 > r6) goto L14;
    L10:
        r0.append(r4);
        if (r7 == r6) goto L14;
        r7 = r7 + 1;
    L14:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
    L7:
        return r5.subSequence(0, r5.length());
    L16:
        throw new IllegalArgumentException("Desired length " + r3 + " is less than zero.");
    }

    public static final String padEnd(String r2, int r3, char r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return StringsKt.padEnd((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3, r4).toString();
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence r1, int r2, char r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = ' ';
    L6:
        return StringsKt.padEnd(r6, r2, r3);
    }

    public static /* synthetic */ String padEnd$default(String r0, int r1, char r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = ' ';
    L6:
        return StringsKt.padEnd(r0, r1, r2);
    }

    public static final CharSequence padStart(CharSequence r3, int r4, char r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (r4 < 0) goto L16;
        if (r4 <= r6.length()) goto L7;
        StringBuilder r0 = new StringBuilder(r4);
        int r7 = r4 - r6.length();
        int r2 = 1;
        if (1 > r7) goto L13;
    L10:
        r0.append(r5);
        if (r2 == r7) goto L13;
        r2 = r2 + 1;
    L13:
        r0.append(r6);
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
    L7:
        return r6.subSequence(0, r6.length());
    L16:
        throw new IllegalArgumentException("Desired length " + r4 + " is less than zero.");
    }

    public static final String padStart(String r2, int r3, char r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return StringsKt.padStart((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3, r4).toString();
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence r1, int r2, char r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = ' ';
    L6:
        return StringsKt.padStart(r6, r2, r3);
    }

    public static /* synthetic */ String padStart$default(String r0, int r1, char r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = ' ';
    L6:
        return StringsKt.padStart(r0, r1, r2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence r3, final char[] r4, int r5, final boolean r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        StringsKt.requireNonNegativeLimit(r7);
        return (Sequence) ZeusTransformUtils.preCheckCast(new DelimitedRangesSequence(r8, r5, r7, (Function2) ZeusTransformUtils.preCheckCast(new StringsKt__StringsKt$rangesDelimitedBy$1(r4, r6), Function2.class, "com.obric.memorydata.plugin")), Sequence.class, "com.obric.memorydata.plugin");
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence r3, String[] r4, int r5, final boolean r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        StringsKt.requireNonNegativeLimit(r7);
        final List r9 = ArraysKt.asList(r4);
        return (Sequence) ZeusTransformUtils.preCheckCast(new DelimitedRangesSequence(r8, r5, r7, (Function2) ZeusTransformUtils.preCheckCast(new StringsKt__StringsKt$rangesDelimitedBy$2(r9, r6), Function2.class, "com.obric.memorydata.plugin")), Sequence.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence r1, char[] r2, int r3, boolean r4, int r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = 0;
    L12:
        return rangesDelimitedBy$StringsKt__StringsKt(r8, r2, r3, r4, r5);
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence r1, String[] r2, int r3, boolean r4, int r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = 0;
    L12:
        return rangesDelimitedBy$StringsKt__StringsKt(r8, r2, r3, r4, r5);
    }

    public static final boolean regionMatchesImpl(CharSequence r4, int r5, CharSequence r6, int r7, int r8, boolean r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        if (r7 < 0) goto L18;
        if (r5 < 0) goto L18;
        if (r5 > (r10.length() - r8)) goto L18;
        if (r7 > (r11.length() - r8)) goto L18;
        int r1 = 0;
    L11:
        if (r1 >= r8) goto L16;
        if (CharsKt.equals(r10.charAt(r5 + r1), r11.charAt(r7 + r1), r9) == false) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }

    public static final CharSequence removePrefix(CharSequence r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "prefix");
        if (StringsKt.startsWith$default(r5, r6, false, 2, null) == false) goto L7;
        return r5.subSequence(r6.length(), r5.length());
    L7:
        return r5.subSequence(0, r5.length());
    }

    public static final String removePrefix(String r4, CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, "prefix");
        if (StringsKt.startsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), r6, false, 2, null) == false) goto L6;
        String r7 = r4.substring(r6.length());
        Intrinsics.checkNotNullExpressionValue(r7, "substring(...)");
        return r7;
    L6:
        return r4;
    }

    public static final CharSequence removeRange(CharSequence r5, int r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (r7 < r6) goto L11;
        if (r7 == r6) goto L7;
        StringBuilder r2 = new StringBuilder(r8.length() - (r7 - r6));
        Intrinsics.checkNotNullExpressionValue(r2.append(r8, 0, r6), "append(...)");
        Intrinsics.checkNotNullExpressionValue(r2.append(r8, r7, r8.length()), "append(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
    L7:
        return r8.subSequence(0, r8.length());
    L11:
        throw new IndexOutOfBoundsException("End index (" + r7 + ") is less than start index (" + r6 + ").");
    }

    public static final CharSequence removeRange(CharSequence r2, IntRange r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "range");
        return StringsKt.removeRange(r4, r3.getStart().intValue(), r3.getEndInclusive().intValue() + 1);
    }

    private static final String removeRange(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return StringsKt.removeRange((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3, r4).toString();
    }

    private static final String removeRange(String r2, IntRange r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "range");
        return StringsKt.removeRange((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3).toString();
    }

    public static final CharSequence removeSuffix(CharSequence r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "suffix");
        if (StringsKt.endsWith$default(r5, r6, false, 2, null) == false) goto L7;
        return r5.subSequence(0, r5.length() - r6.length());
    L7:
        return r5.subSequence(0, r5.length());
    }

    public static final String removeSuffix(String r4, CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, "suffix");
        if (StringsKt.endsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), r6, false, 2, null) == false) goto L6;
        String r7 = r4.substring(0, r4.length() - r6.length());
        Intrinsics.checkNotNullExpressionValue(r7, "substring(...)");
        return r7;
    L6:
        return r4;
    }

    public static final CharSequence removeSurrounding(CharSequence r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "delimiter");
        return StringsKt.removeSurrounding(r4, r5, r5);
    }

    public static final CharSequence removeSurrounding(CharSequence r4, CharSequence r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "prefix");
        Intrinsics.checkNotNullParameter(r9, "suffix");
        if (r7.length() < (r8.length() + r9.length())) goto L11;
        if (StringsKt.startsWith$default(r7, r8, false, 2, null) == false) goto L11;
        if (StringsKt.endsWith$default(r7, r9, false, 2, null) == false) goto L11;
        return r7.subSequence(r8.length(), r7.length() - r9.length());
    L11:
        return r7.subSequence(0, r7.length());
    }

    public static final String removeSurrounding(String r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "delimiter");
        return StringsKt.removeSurrounding(r2, r4, r4);
    }

    public static final String removeSurrounding(String r5, CharSequence r6, CharSequence r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r8, "prefix");
        Intrinsics.checkNotNullParameter(r9, "suffix");
        if (r5.length() >= (r8.length() + r9.length())) goto L5;
        return r5;
    L5:
        if (StringsKt.startsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), r8, false, 2, null) == true) goto L7;
        return r5;
    L7:
        if (StringsKt.endsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), r9, false, 2, null) == false) goto L12;
        String r10 = r5.substring(r8.length(), r5.length() - r9.length());
        Intrinsics.checkNotNullExpressionValue(r10, "substring(...)");
        return r10;
    L12:
        return r5;
    }

    private static final String replace(CharSequence r2, Regex r3, String r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r3, "regex");
        Intrinsics.checkNotNullParameter(r4, "replacement");
        return r3.replace(r5, r4);
    }

    private static final String replace(CharSequence r2, Regex r3, Function1<? super MatchResult, ? extends CharSequence> r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Function1<? super MatchResult, ? extends CharSequence> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r3, "regex");
        Intrinsics.checkNotNullParameter(r6, "transform");
        return r3.replace(r5, r6);
    }

    public static final String replaceAfter(String r8, char r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r10, "replacement");
        Intrinsics.checkNotNullParameter(r11, "missingDelimiterValue");
        int r12 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), r9, 0, false, 6, null);
        if (r12 == (-1)) goto L7;
        int r13 = r8.length();
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        return StringsKt.replaceRange(r14, r12 + 1, r13, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L7:
        return r11;
    }

    public static final String replaceAfter(String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "delimiter");
        Intrinsics.checkNotNullParameter(r10, "replacement");
        Intrinsics.checkNotNullParameter(r11, "missingDelimiterValue");
        int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), r9, 0, false, 6, null);
        if (r0 == (-1)) goto L7;
        int r1 = r0 + r9.length();
        int r12 = r8.length();
        return StringsKt.replaceRange((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), r1, r12, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L7:
        return r11;
    }

    public static /* synthetic */ String replaceAfter$default(String r0, char r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceAfter(r0, r1, r2, r3);
    }

    public static /* synthetic */ String replaceAfter$default(String r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceAfter(r0, r1, r2, r3);
    }

    public static final String replaceAfterLast(String r8, char r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r10, "replacement");
        Intrinsics.checkNotNullParameter(r11, "missingDelimiterValue");
        int r12 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), r9, 0, false, 6, null);
        if (r12 == (-1)) goto L7;
        int r13 = r8.length();
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        return StringsKt.replaceRange(r14, r12 + 1, r13, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L7:
        return r11;
    }

    public static final String replaceAfterLast(String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "delimiter");
        Intrinsics.checkNotNullParameter(r10, "replacement");
        Intrinsics.checkNotNullParameter(r11, "missingDelimiterValue");
        int r0 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), r9, 0, false, 6, null);
        if (r0 == (-1)) goto L7;
        int r1 = r0 + r9.length();
        int r12 = r8.length();
        return StringsKt.replaceRange((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), r1, r12, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L7:
        return r11;
    }

    public static /* synthetic */ String replaceAfterLast$default(String r0, char r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceAfterLast(r0, r1, r2, r3);
    }

    public static /* synthetic */ String replaceAfterLast$default(String r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceAfterLast(r0, r1, r2, r3);
    }

    public static final String replaceBefore(String r8, char r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r10, "replacement");
        Intrinsics.checkNotNullParameter(r11, "missingDelimiterValue");
        int r12 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), r9, 0, false, 6, null);
        if (r12 != (-1)) goto L6;
        return r11;
    L6:
        return StringsKt.replaceRange((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), 0, r12, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    public static final String replaceBefore(String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "delimiter");
        Intrinsics.checkNotNullParameter(r10, "replacement");
        Intrinsics.checkNotNullParameter(r11, "missingDelimiterValue");
        int r12 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), r9, 0, false, 6, null);
        if (r12 != (-1)) goto L6;
        return r11;
    L6:
        return StringsKt.replaceRange((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), 0, r12, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    public static /* synthetic */ String replaceBefore$default(String r0, char r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceBefore(r0, r1, r2, r3);
    }

    public static /* synthetic */ String replaceBefore$default(String r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceBefore(r0, r1, r2, r3);
    }

    public static final String replaceBeforeLast(String r8, char r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r10, "replacement");
        Intrinsics.checkNotNullParameter(r11, "missingDelimiterValue");
        int r12 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), r9, 0, false, 6, null);
        if (r12 != (-1)) goto L6;
        return r11;
    L6:
        return StringsKt.replaceRange((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), 0, r12, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    public static final String replaceBeforeLast(String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "delimiter");
        Intrinsics.checkNotNullParameter(r10, "replacement");
        Intrinsics.checkNotNullParameter(r11, "missingDelimiterValue");
        int r12 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), r9, 0, false, 6, null);
        if (r12 != (-1)) goto L6;
        return r11;
    L6:
        return StringsKt.replaceRange((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), 0, r12, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String r0, char r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceBeforeLast(r0, r1, r2, r3);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceBeforeLast(r0, r1, r2, r3);
    }

    private static final String replaceFirst(CharSequence r2, Regex r3, String r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r3, "regex");
        Intrinsics.checkNotNullParameter(r4, "replacement");
        return r3.replaceFirst(r5, r4);
    }

    private static final String replaceFirstCharWithChar(String r4, Function1<? super Character, Character> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, "transform");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        char r7 = ((Character) ZeusTransformUtils.preCheckCast(r6.invoke(Character.valueOf(r4.charAt(0))), Character.class, "com.obric.memorydata.plugin")).charValue();
        String r8 = r4.substring(1);
        Intrinsics.checkNotNullExpressionValue(r8, "substring(...)");
        return r7 + r8;
    L9:
        return r4;
    L5:
        r0 = false;
        goto L6
    }

    private static final String replaceFirstCharWithCharSequence(String r3, Function1<? super Character, ? extends CharSequence> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r5, "transform");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        StringBuilder r6 = new StringBuilder().append(r5.invoke(Character.valueOf(r3.charAt(0))));
        String r7 = r3.substring(1);
        Intrinsics.checkNotNullExpressionValue(r7, "substring(...)");
        return r6.append(r7).toString();
    L9:
        return r3;
    L5:
        r0 = false;
        goto L6
    }

    public static final CharSequence replaceRange(CharSequence r3, int r4, int r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "replacement");
        if (r5 < r4) goto L7;
        StringBuilder r0 = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(r0.append(r7, 0, r4), "append(...)");
        r0.append(r8);
        Intrinsics.checkNotNullExpressionValue(r0.append(r7, r5, r7.length()), "append(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
    L7:
        throw new IndexOutOfBoundsException("End index (" + r5 + ") is less than start index (" + r4 + ").");
    }

    public static final CharSequence replaceRange(CharSequence r2, IntRange r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r3, "range");
        Intrinsics.checkNotNullParameter(r6, "replacement");
        return StringsKt.replaceRange(r5, r3.getStart().intValue(), r3.getEndInclusive().intValue() + 1, r6);
    }

    private static final String replaceRange(String r2, int r3, int r4, CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r6, "replacement");
        return StringsKt.replaceRange((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3, r4, r6).toString();
    }

    private static final String replaceRange(String r2, IntRange r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "range");
        Intrinsics.checkNotNullParameter(r5, "replacement");
        return StringsKt.replaceRange((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3, r5).toString();
    }

    public static final void requireNonNegativeLimit(int r2) {
        if (r2 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + r2).toString());
    L4:
        r0 = false;
        goto L5
    }

    private static final List<String> split(CharSequence r2, Regex r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r3, "regex");
        return r3.split(r5, r4);
    }

    public static final List<String> split(CharSequence r9, char[] r10, boolean r11, int r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r10, "delimiters");
        if (r10.length == 1) goto L5;
        Iterable r14 = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(r13, r10, 0, r11, r12, 2, null));
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L11;
        r15.add(StringsKt.substring(r13, (IntRange) ZeusTransformUtils.preCheckCast(r16.next(), IntRange.class, "com.obric.memorydata.plugin")));
        goto L8
    L11:
        return (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
    L5:
        return split$StringsKt__StringsKt(r13, String.valueOf(r10[0]), r11, r12);
    }

    public static final List<String> split(CharSequence r9, String[] r10, boolean r11, int r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r10, "delimiters");
        boolean r2 = true;
        if (r10.length != 1) goto L11;
        String r3 = r10[0];
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L8;
        r2 = false;
    L8:
        if (r2 == true) goto L11;
        return split$StringsKt__StringsKt(r13, r3, r11, r12);
    L11:
        Iterable r14 = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(r13, r10, 0, r11, r12, 2, null));
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L13:
        if (r16.hasNext() == false) goto L16;
        r15.add(StringsKt.substring(r13, (IntRange) ZeusTransformUtils.preCheckCast(r16.next(), IntRange.class, "com.obric.memorydata.plugin")));
        goto L13
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence r8, String r9, boolean r10, int r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        StringsKt.requireNonNegativeLimit(r11);
        int r0 = 0;
        int r2 = StringsKt.indexOf(r12, r9, 0, r10);
        if (r2 == (-1)) goto L23;
        if (r11 == 1) goto L23;
        if (r11 <= 0) goto L9;
        boolean r5 = true;
    L10:
        int r7 = 10;
        if (r5 == false) goto L13;
        r7 = RangesKt.coerceAtMost(r11, 10);
    L13:
        ArrayList r6 = new ArrayList(r7);
    L14:
        r6.add(r12.subSequence(r0, r2).toString());
        r0 = r9.length() + r2;
        if (r5 == true) goto L17;
    L18:
        r2 = StringsKt.indexOf(r12, r9, r0, r10);
        if (r2 != (-1)) goto L14;
    L20:
        r6.add(r12.subSequence(r0, r12.length()).toString());
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
    L17:
        if (r6.size() == (r11 - 1)) goto L20;
    L9:
        r5 = false;
    L23:
        return CollectionsKt.listOf(r12.toString());
    }

    static /* synthetic */ List split$default(CharSequence r1, Regex r2, int r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r2, "regex");
        return r2.split(r6, r3);
    }

    public static /* synthetic */ List split$default(CharSequence r1, char[] r2, boolean r3, int r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return StringsKt.split(r7, r2, r3, r4);
    }

    public static /* synthetic */ List split$default(CharSequence r1, String[] r2, boolean r3, int r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return StringsKt.split(r7, r2, r3, r4);
    }

    private static final Sequence<String> splitToSequence(CharSequence r2, Regex r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r3, "regex");
        return r3.splitToSequence(r5, r4);
    }

    public static final Sequence<String> splitToSequence(CharSequence r9, char[] r10, boolean r11, int r12) {
        final CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r10, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(r13, r10, 0, r11, r12, 2, null), (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r13), Function1.class, "com.obric.memorydata.plugin"));
    }

    public static final Sequence<String> splitToSequence(CharSequence r9, String[] r10, boolean r11, int r12) {
        final CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r10, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(r13, r10, 0, r11, r12, 2, null), (Function1) ZeusTransformUtils.preCheckCast(new C12821(r13), Function1.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Sequence splitToSequence$default(CharSequence r1, Regex r2, int r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r2, "regex");
        return r2.splitToSequence(r6, r3);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence r1, char[] r2, boolean r3, int r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return StringsKt.splitToSequence(r7, r2, r3, r4);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence r1, String[] r2, boolean r3, int r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return StringsKt.splitToSequence(r7, r2, r3, r4);
    }

    public static final boolean startsWith(CharSequence r2, char r3, boolean r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.length() > 0) goto L5;
        return false;
    L5:
        if (CharsKt.equals(r5.charAt(0), r3, r4) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean startsWith(CharSequence r11, CharSequence r12, int r13, boolean r14) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        if (r14 == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L11;
        return StringsKt.startsWith$default((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), r13, false, 4, null);
    L11:
        return StringsKt.regionMatchesImpl(r2, r13, r4, 0, r4.length(), r14);
    }

    public static final boolean startsWith(CharSequence r8, CharSequence r9, boolean r10) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        if (r10 == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L11;
        return StringsKt.startsWith$default((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), false, 2, null);
    L11:
        return StringsKt.regionMatchesImpl(r2, 0, r4, 0, r4.length(), r10);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r1, char r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return StringsKt.startsWith(r6, r2, r3);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r1, CharSequence r2, int r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L6;
        r4 = false;
    L6:
        return StringsKt.startsWith(r7, r8, r3, r4);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r1, CharSequence r2, boolean r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return StringsKt.startsWith(r6, r7, r3);
    }

    public static final CharSequence subSequence(CharSequence r2, IntRange r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "range");
        return r4.subSequence(r3.getStart().intValue(), r3.getEndInclusive().intValue() + 1);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    private static final CharSequence subSequence(String r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.subSequence(r2, r3);
    }

    private static final String substring(CharSequence r2, int r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.subSequence(r3, r4).toString();
    }

    public static final String substring(CharSequence r2, IntRange r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "range");
        return r4.subSequence(r3.getStart().intValue(), r3.getEndInclusive().intValue() + 1).toString();
    }

    public static final String substring(String r1, IntRange r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "range");
        String r3 = r1.substring(r2.getStart().intValue(), r2.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
        return r3;
    }

    static /* synthetic */ String substring$default(CharSequence r1, int r2, int r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = r6.length();
    L5:
        Intrinsics.checkNotNullParameter(r6, "<this>");
        return r6.subSequence(r2, r3).toString();
    }

    public static final String substringAfter(String r7, char r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r10 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(r10 + 1, r7.length());
        Intrinsics.checkNotNullExpressionValue(r11, "substring(...)");
        return r11;
    L7:
        return r9;
    }

    public static final String substringAfter(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiter");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), r8, 0, false, 6, null);
        if (r0 == (-1)) goto L7;
        String r10 = r7.substring(r0 + r8.length(), r7.length());
        Intrinsics.checkNotNullExpressionValue(r10, "substring(...)");
        return r10;
    L7:
        return r9;
    }

    public static /* synthetic */ String substringAfter$default(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringAfter(r0, r1, r2);
    }

    public static /* synthetic */ String substringAfter$default(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringAfter(r0, r1, r2);
    }

    public static final String substringAfterLast(String r7, char r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r10 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(r10 + 1, r7.length());
        Intrinsics.checkNotNullExpressionValue(r11, "substring(...)");
        return r11;
    L7:
        return r9;
    }

    public static final String substringAfterLast(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiter");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r0 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), r8, 0, false, 6, null);
        if (r0 == (-1)) goto L7;
        String r10 = r7.substring(r0 + r8.length(), r7.length());
        Intrinsics.checkNotNullExpressionValue(r10, "substring(...)");
        return r10;
    L7:
        return r9;
    }

    public static /* synthetic */ String substringAfterLast$default(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringAfterLast(r0, r1, r2);
    }

    public static /* synthetic */ String substringAfterLast$default(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringAfterLast(r0, r1, r2);
    }

    public static final String substringBefore(String r7, char r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r10 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        Intrinsics.checkNotNullExpressionValue(r11, "substring(...)");
        return r11;
    L7:
        return r9;
    }

    public static final String substringBefore(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiter");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r10 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        Intrinsics.checkNotNullExpressionValue(r11, "substring(...)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String substringBefore$default(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringBefore(r0, r1, r2);
    }

    public static /* synthetic */ String substringBefore$default(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringBefore(r0, r1, r2);
    }

    public static final String substringBeforeLast(String r7, char r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r10 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        Intrinsics.checkNotNullExpressionValue(r11, "substring(...)");
        return r11;
    L7:
        return r9;
    }

    public static final String substringBeforeLast(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiter");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r10 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        Intrinsics.checkNotNullExpressionValue(r11, "substring(...)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String substringBeforeLast$default(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringBeforeLast(r0, r1, r2);
    }

    public static /* synthetic */ String substringBeforeLast$default(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringBeforeLast(r0, r1, r2);
    }

    public static final boolean toBooleanStrict(String r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (Intrinsics.areEqual(r3, "true") == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r3, "false") == false) goto L10;
        return false;
    L10:
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + r3);
    }

    public static final Boolean toBooleanStrictOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (Intrinsics.areEqual(r1, "true") == false) goto L7;
        boolean r2 = true;
    L11:
        return Boolean.valueOf(r2);
    L7:
        if (Intrinsics.areEqual(r1, "false") == false) goto L9;
        r2 = false;
        goto L11
    L9:
        return null;
    }

    public static final CharSequence trim(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        int r0 = r6.length() - 1;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 > r0) goto L16;
        if (r3 == true) goto L6;
        int r4 = r2;
    L7:
        boolean r7 = CharsKt.isWhitespace(r6.charAt(r4));
        if (r3 == false) goto L9;
        if (r7 == false) goto L16;
        r0 = r0 - 1;
        goto L3
    L9:
        if (r7 == false) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        r3 = true;
        goto L3
    L6:
        r4 = r0;
    L16:
        return r6.subSequence(r2, r0 + 1);
    }

    public static final CharSequence trim(CharSequence r7, Function1<? super Character, Boolean> r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        int r0 = r9.length() - 1;
        int r3 = 0;
        boolean r4 = false;
    L3:
        if (r3 > r0) goto L16;
        if (r4 == true) goto L6;
        int r5 = r3;
    L7:
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r10.invoke(Character.valueOf(r9.charAt(r5))), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r4 == false) goto L9;
        if (r6 == false) goto L16;
        r0 = r0 - 1;
        goto L3
    L9:
        if (r6 == false) goto L10;
        r3 = r3 + 1;
        goto L3
    L10:
        r4 = true;
        goto L3
    L6:
        r5 = r0;
    L16:
        return r9.subSequence(r3, r0 + 1);
    }

    public static final CharSequence trim(CharSequence r5, char... r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r6, "chars");
        int r0 = r7.length() - 1;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 > r0) goto L16;
        if (r3 == true) goto L6;
        int r4 = r2;
    L7:
        boolean r8 = ArraysKt.contains(r6, r7.charAt(r4));
        if (r3 == false) goto L9;
        if (r8 == false) goto L16;
        r0 = r0 - 1;
        goto L3
    L9:
        if (r8 == false) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        r3 = true;
        goto L3
    L6:
        r4 = r0;
    L16:
        return r7.subSequence(r2, r0 + 1);
    }

    private static final String trim(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    public static final String trim(String r7, Function1<? super Character, Boolean> r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "predicate");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r10.length() - 1;
        int r3 = 0;
        boolean r4 = false;
    L3:
        if (r3 > r0) goto L16;
        if (r4 == true) goto L6;
        int r5 = r3;
    L7:
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r9.invoke(Character.valueOf(r10.charAt(r5))), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r4 == false) goto L9;
        if (r6 == false) goto L16;
        r0 = r0 - 1;
        goto L3
    L9:
        if (r6 == false) goto L10;
        r3 = r3 + 1;
        goto L3
    L10:
        r4 = true;
        goto L3
    L6:
        r5 = r0;
    L16:
        return r10.subSequence(r3, r0 + 1).toString();
    }

    public static final String trim(String r5, char... r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "chars");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r7.length() - 1;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 > r0) goto L16;
        if (r3 == true) goto L6;
        int r4 = r2;
    L7:
        boolean r8 = ArraysKt.contains(r6, r7.charAt(r4));
        if (r3 == false) goto L9;
        if (r8 == false) goto L16;
        r0 = r0 - 1;
        goto L3
    L9:
        if (r8 == false) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        r3 = true;
        goto L3
    L6:
        r4 = r0;
    L16:
        return r7.subSequence(r2, r0 + 1).toString();
    }

    public static final CharSequence trimEnd(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.length() - 1;
        if (r0 < 0) goto L11;
    L4:
        int r2 = r0 - 1;
        if (CharsKt.isWhitespace(r5.charAt(r0)) == false) goto L14;
        if (r2 < 0) goto L11;
        r0 = r2;
        goto L4
    L14:
        return r5.subSequence(0, r0 + 1);
    L11:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final CharSequence trimEnd(CharSequence r5, Function1<? super Character, Boolean> r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "predicate");
        int r0 = r7.length() - 1;
        if (r0 < 0) goto L12;
    L4:
        int r2 = r0 - 1;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(Character.valueOf(r7.charAt(r0))), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        if (r2 < 0) goto L12;
        r0 = r2;
        goto L4
    L7:
        return r7.subSequence(0, r0 + 1);
    L12:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final CharSequence trimEnd(CharSequence r4, char... r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r5, "chars");
        int r0 = r6.length() - 1;
        if (r0 < 0) goto L11;
    L4:
        int r2 = r0 - 1;
        if (ArraysKt.contains(r5, r6.charAt(r0)) == false) goto L14;
        if (r2 < 0) goto L11;
        r0 = r2;
        goto L4
    L14:
        return r6.subSequence(0, r0 + 1);
    L11:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final String trimEnd(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return StringsKt.trimEnd((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    public static final String trimEnd(String r5, Function1<? super Character, Boolean> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r7, "predicate");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r8.length() - 1;
        if (r0 < 0) goto L10;
    L4:
        int r2 = r0 - 1;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(Character.valueOf(r8.charAt(r0))), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        if (r2 < 0) goto L10;
        r0 = r2;
        goto L4
    L6:
        CharSequence r9 = r8.subSequence(0, r0 + 1);
    L12:
        return r9.toString();
    L10:
        r9 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        goto L12
    }

    public static final String trimEnd(String r4, char... r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "chars");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r6.length() - 1;
        if (r0 < 0) goto L10;
    L4:
        int r2 = r0 - 1;
        if (ArraysKt.contains(r5, r6.charAt(r0)) == false) goto L6;
        if (r2 < 0) goto L10;
        r0 = r2;
        goto L4
    L6:
        CharSequence r7 = r6.subSequence(0, r0 + 1);
    L12:
        return r7.toString();
    L10:
        r7 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        goto L12
    }

    public static final CharSequence trimStart(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (CharsKt.isWhitespace(r5.charAt(r2)) == false) goto L12;
        r2 = r2 + 1;
        goto L3
    L12:
        return r5.subSequence(r2, r5.length());
    L9:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final CharSequence trimStart(CharSequence r5, Function1<? super Character, Boolean> r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "predicate");
        int r0 = r7.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(Character.valueOf(r7.charAt(r2))), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return r7.subSequence(r2, r7.length());
    L10:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final CharSequence trimStart(CharSequence r4, char... r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r5, "chars");
        int r0 = r6.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (ArraysKt.contains(r5, r6.charAt(r2)) == false) goto L12;
        r2 = r2 + 1;
        goto L3
    L12:
        return r6.subSequence(r2, r6.length());
    L9:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final String trimStart(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return StringsKt.trimStart((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    public static final String trimStart(String r5, Function1<? super Character, Boolean> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r7, "predicate");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r8.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(Character.valueOf(r8.charAt(r2))), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        CharSequence r9 = r8.subSequence(r2, r8.length());
    L10:
        return r9.toString();
    L8:
        r9 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        goto L10
    }

    public static final String trimStart(String r4, char... r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "chars");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r6.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (ArraysKt.contains(r5, r6.charAt(r2)) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        CharSequence r7 = r6.subSequence(r2, r6.length());
    L10:
        return r7.toString();
    L8:
        r7 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        goto L10
    }
}
