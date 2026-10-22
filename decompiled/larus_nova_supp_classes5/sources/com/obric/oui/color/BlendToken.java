package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0003\b¯\u0001\bÇ\u0002\u0018\u00002\u00020\u0001B\n\b\u0002¢\u0006\u0005\bÂ\u0001\u0010%J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J,\u0010\f\u001a\u00020\u00052\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J8\u0010\u000f\u001a\u00020\u00052$\u0010\u000b\u001a \u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e0\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J&\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0007J)\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0011\u0010\u0013R-\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R9\u0010\u001c\u001a \u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e0\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR2\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b \u0010!\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001eR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001eR2\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b(\u0010!\u0012\u0004\b*\u0010%\u001a\u0004\b)\u0010#R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001eR\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b,\u0010\u001eR2\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b-\u0010!\u0012\u0004\b/\u0010%\u001a\u0004\b.\u0010#R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u0010\u001eR\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b1\u0010\u001eR2\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b2\u0010!\u0012\u0004\b4\u0010%\u001a\u0004\b3\u0010#R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b5\u0010\u001eR\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b6\u0010\u001eR2\u00107\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b7\u0010!\u0012\u0004\b9\u0010%\u001a\u0004\b8\u0010#R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b:\u0010\u001eR\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b;\u0010\u001eR2\u0010<\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b<\u0010!\u0012\u0004\b>\u0010%\u001a\u0004\b=\u0010#R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b?\u0010\u001eR\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b@\u0010\u001eR2\u0010A\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bA\u0010!\u0012\u0004\bC\u0010%\u001a\u0004\bB\u0010#R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bD\u0010\u001eR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bE\u0010\u001eR2\u0010F\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bF\u0010!\u0012\u0004\bH\u0010%\u001a\u0004\bG\u0010#R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bI\u0010\u001eR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u001eR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bK\u0010\u001eR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bL\u0010\u001eR2\u0010M\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bM\u0010!\u0012\u0004\bO\u0010%\u001a\u0004\bN\u0010#R\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u0010\u001eR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bQ\u0010\u001eR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bR\u0010\u001eR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bS\u0010\u001eR2\u0010T\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bT\u0010!\u0012\u0004\bV\u0010%\u001a\u0004\bU\u0010#R\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bW\u0010\u001eR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bX\u0010\u001eR2\u0010Y\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bY\u0010!\u0012\u0004\b[\u0010%\u001a\u0004\bZ\u0010#R\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\\\u0010\u001eR\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b]\u0010\u001eR2\u0010^\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b^\u0010!\u0012\u0004\b`\u0010%\u001a\u0004\b_\u0010#R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\ba\u0010\u001eR\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bb\u0010\u001eR\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bc\u0010\u001eR\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bd\u0010\u001eR2\u0010e\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\be\u0010!\u0012\u0004\bg\u0010%\u001a\u0004\bf\u0010#R\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bh\u0010\u001eR\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bi\u0010\u001eR2\u0010j\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bj\u0010!\u0012\u0004\bl\u0010%\u001a\u0004\bk\u0010#R\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bm\u0010\u001eR\u001a\u0010n\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bn\u0010\u001eR2\u0010o\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bo\u0010!\u0012\u0004\bq\u0010%\u001a\u0004\bp\u0010#R\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\br\u0010\u001eR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bs\u0010\u001eR2\u0010t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bt\u0010!\u0012\u0004\bv\u0010%\u001a\u0004\bu\u0010#R\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bw\u0010\u001eR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bx\u0010\u001eR2\u0010y\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\by\u0010!\u0012\u0004\b{\u0010%\u001a\u0004\bz\u0010#R\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b|\u0010\u001eR\u001a\u0010}\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b}\u0010\u001eR3\u0010~\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0013\n\u0004\b~\u0010!\u0012\u0005\b\u0080\u0001\u0010%\u001a\u0004\b\u007f\u0010#R\u001c\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010\u001eR\u001c\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010\u001eR6\u0010\u0083\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010!\u0012\u0005\b\u0085\u0001\u0010%\u001a\u0005\b\u0084\u0001\u0010#R\u001c\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010\u001eR\u001c\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010\u001eR6\u0010\u0088\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010!\u0012\u0005\b\u008a\u0001\u0010%\u001a\u0005\b\u0089\u0001\u0010#R\u0017\u0010\u008b\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0017\u0010\u008d\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008c\u0001R\u0017\u0010\u008e\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008c\u0001R\u0017\u0010\u008f\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u008c\u0001R\u001c\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010\u001eR\u001c\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010\u001eR6\u0010\u0092\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b\u0092\u0001\u0010!\u0012\u0005\b\u0094\u0001\u0010%\u001a\u0005\b\u0093\u0001\u0010#R\u001c\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010\u001eR\u001c\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010\u001eR6\u0010\u0097\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010!\u0012\u0005\b\u0099\u0001\u0010%\u001a\u0005\b\u0098\u0001\u0010#R\u001c\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010\u001eR\u001c\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010\u001eR6\u0010\u009c\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010!\u0012\u0005\b\u009e\u0001\u0010%\u001a\u0005\b\u009d\u0001\u0010#R\u001c\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010\u001eR\u001c\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b \u0001\u0010\u001eR6\u0010¡\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b¡\u0001\u0010!\u0012\u0005\b£\u0001\u0010%\u001a\u0005\b¢\u0001\u0010#R\u001c\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b¤\u0001\u0010\u001eR\u001c\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b¥\u0001\u0010\u001eR6\u0010¦\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b¦\u0001\u0010!\u0012\u0005\b¨\u0001\u0010%\u001a\u0005\b§\u0001\u0010#R\u001c\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b©\u0001\u0010\u001eR\u001c\u0010ª\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\bª\u0001\u0010\u001eR6\u0010«\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b«\u0001\u0010!\u0012\u0005\b\u00ad\u0001\u0010%\u001a\u0005\b¬\u0001\u0010#R\u001c\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b®\u0001\u0010\u001eR\u001c\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b¯\u0001\u0010\u001eR6\u0010°\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b°\u0001\u0010!\u0012\u0005\b²\u0001\u0010%\u001a\u0005\b±\u0001\u0010#R\u001c\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b³\u0001\u0010\u001eR\u001c\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b´\u0001\u0010\u001eR6\u0010µ\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\bµ\u0001\u0010!\u0012\u0005\b·\u0001\u0010%\u001a\u0005\b¶\u0001\u0010#R\u001c\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b¸\u0001\u0010\u001eR\u001c\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b¹\u0001\u0010\u001eR6\u0010º\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\bº\u0001\u0010!\u0012\u0005\b¼\u0001\u0010%\u001a\u0005\b»\u0001\u0010#R\u001c\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b½\u0001\u0010\u001eR\u001c\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b¾\u0001\u0010\u001eR6\u0010¿\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b¿\u0001\u0010!\u0012\u0005\bÁ\u0001\u0010%\u001a\u0005\bÀ\u0001\u0010#¨\u0006Ã\u0001"}, d2 = {"Lcom/obric/oui/color/BlendToken;", "", "customTokenOwner", "", "overrideExisting", "", "register", "", "", "", "Lcom/obric/oui/color/a;", "customTokens", "registerTokens", "registerProvider", "Lkotlin/Function1;", "registerProviderTokens", DBDefinition.NAME, "parse", "isLight", "(Ljava/lang/String;Z)[Lcom/obric/oui/color/a;", "Ljava/util/concurrent/ConcurrentHashMap;", "tokens$delegate", "Lkotlin/Lazy;", "getTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", "tokens", "providers$delegate", "getProviders", "providers", "Blend_Base_Thick_Light", "[Lcom/obric/oui/color/a;", "Blend_Base_Thick_Dark", "Blend_Base_Thick", "Lkotlin/jvm/functions/Function1;", "getBlend_Base_Thick", "()Lkotlin/jvm/functions/Function1;", "getBlend_Base_Thick$annotations", "()V", "Blend_Base_Regular_Light", "Blend_Base_Regular_Dark", "Blend_Base_Regular", "getBlend_Base_Regular", "getBlend_Base_Regular$annotations", "OUI_Color_Blend_Frost_Regular_Light", "OUI_Color_Blend_Frost_Regular_Dark", "OUI_Color_Blend_Frost_Regular", "getOUI_Color_Blend_Frost_Regular", "getOUI_Color_Blend_Frost_Regular$annotations", "OUI_Color_Blend_Fluid_Regular_Light", "OUI_Color_Blend_Fluid_Regular_Dark", "OUI_Color_Blend_Fluid_Regular", "getOUI_Color_Blend_Fluid_Regular", "getOUI_Color_Blend_Fluid_Regular$annotations", "OUI_Color_Blend_Frost_UltraThin_Light", "OUI_Color_Blend_Frost_UltraThin_Dark", "OUI_Color_Blend_Frost_UltraThin", "getOUI_Color_Blend_Frost_UltraThin", "getOUI_Color_Blend_Frost_UltraThin$annotations", "OUI_Color_Blend_Fluid_UltraThin_Light", "OUI_Color_Blend_Fluid_UltraThin_Dark", "OUI_Color_Blend_Fluid_UltraThin", "getOUI_Color_Blend_Fluid_UltraThin", "getOUI_Color_Blend_Fluid_UltraThin$annotations", "OUI_Color_Blend_Frost_Thin_Light", "OUI_Color_Blend_Frost_Thin_Dark", "OUI_Color_Blend_Frost_Thin", "getOUI_Color_Blend_Frost_Thin", "getOUI_Color_Blend_Frost_Thin$annotations", "OUI_Color_Blend_Fluid_Thin_Light", "OUI_Color_Blend_Fluid_Thin_Dark", "OUI_Color_Blend_Fluid_Thin", "getOUI_Color_Blend_Fluid_Thin", "getOUI_Color_Blend_Fluid_Thin$annotations", "OUI_Color_Blend_Frost_Thick_Light", "OUI_Color_Blend_Frost_Thick_Dark", "OUI_Color_Blend_Fluid_Thick_Light", "OUI_Color_Blend_Fluid_Thick_Dark", "OUI_Color_Blend_Fluid_Thick", "getOUI_Color_Blend_Fluid_Thick", "getOUI_Color_Blend_Fluid_Thick$annotations", "OUI_Color_Fills_Thick_Light", "OUI_Color_Fills_Thick_Dark", "OUI_Color_Blend_Text_Primary_Light", "OUI_Color_Blend_Text_Primary_Dark", "OUI_Color_Blend_Text_Primary", "getOUI_Color_Blend_Text_Primary", "getOUI_Color_Blend_Text_Primary$annotations", "OUI_Color_Blend_Text_Secondary_Light", "OUI_Color_Blend_Text_Secondary_Dark", "OUI_Color_Blend_Text_Secondary", "getOUI_Color_Blend_Text_Secondary", "getOUI_Color_Blend_Text_Secondary$annotations", "OUI_Color_Blend_Text_Tertiary_Light", "OUI_Color_Blend_Text_Tertiary_Dark", "OUI_Color_Blend_Text_Tertiary", "getOUI_Color_Blend_Text_Tertiary", "getOUI_Color_Blend_Text_Tertiary$annotations", "OUI_Color_Blend_Fill_Tinted_Light", "OUI_Color_Blend_Fill_Tinted_Dark", "OUI_Color_Blend_Blue_Thin_Light", "OUI_Color_Blend_Blue_Thin_Dark", "OUI_Color_Blend_Blue_Thin", "getOUI_Color_Blend_Blue_Thin", "getOUI_Color_Blend_Blue_Thin$annotations", "OUI_Color_Blend_Blue_Regular_Light", "OUI_Color_Blend_Blue_Regular_Dark", "OUI_Color_Blend_Blue_Regular", "getOUI_Color_Blend_Blue_Regular", "getOUI_Color_Blend_Blue_Regular$annotations", "OUI_Color_Blend_Red_Thin_Light", "OUI_Color_Blend_Red_Thin_Dark", "OUI_Color_Blend_Red_Thin", "getOUI_Color_Blend_Red_Thin", "getOUI_Color_Blend_Red_Thin$annotations", "OUI_Color_Blend_Red_Regular_Light", "OUI_Color_Blend_Red_Regular_Dark", "OUI_Color_Blend_Red_Regular", "getOUI_Color_Blend_Red_Regular", "getOUI_Color_Blend_Red_Regular$annotations", "OUI_Color_Blend_Green_Thin_Light", "OUI_Color_Blend_Green_Thin_Dark", "OUI_Color_Blend_Green_Thin", "getOUI_Color_Blend_Green_Thin", "getOUI_Color_Blend_Green_Thin$annotations", "OUI_Color_Blend_Green_Regular_Light", "OUI_Color_Blend_Green_Regular_Dark", "OUI_Color_Blend_Green_Regular", "getOUI_Color_Blend_Green_Regular", "getOUI_Color_Blend_Green_Regular$annotations", "OUI_Color_Blend_Yellow_Thin_Light", "OUI_Color_Blend_Yellow_Thin_Dark", "OUI_Color_Blend_Yellow_Thin", "getOUI_Color_Blend_Yellow_Thin", "getOUI_Color_Blend_Yellow_Thin$annotations", "OUI_Color_Blend_Yellow_Regular_Light", "OUI_Color_Blend_Yellow_Regular_Dark", "OUI_Color_Blend_Yellow_Regular", "getOUI_Color_Blend_Yellow_Regular", "getOUI_Color_Blend_Yellow_Regular$annotations", "OUI_Color_State_Press_Light", "Lcom/obric/oui/color/a;", "OUI_Color_State_Press_Dark", "OUI_Color_State_Active_Light", "OUI_Color_State_Active_Dark", "Blend_Blue_6_Light", "Blend_Blue_6_Dark", "Blend_Blue_6", "getBlend_Blue_6", "getBlend_Blue_6$annotations", "Blend_Blue_4_Light", "Blend_Blue_4_Dark", "Blend_Blue_4", "getBlend_Blue_4", "getBlend_Blue_4$annotations", "Blend_Yellow_6_Light", "Blend_Yellow_6_Dark", "Blend_Yellow_6", "getBlend_Yellow_6", "getBlend_Yellow_6$annotations", "Blend_Yellow_4_Light", "Blend_Yellow_4_Dark", "Blend_Yellow_4", "getBlend_Yellow_4", "getBlend_Yellow_4$annotations", "Blend_Green_6_Light", "Blend_Green_6_Dark", "Blend_Green_6", "getBlend_Green_6", "getBlend_Green_6$annotations", "Blend_Green_4_Light", "Blend_Green_4_Dark", "Blend_Green_4", "getBlend_Green_4", "getBlend_Green_4$annotations", "Blend_Red_6_Light", "Blend_Red_6_Dark", "Blend_Red_6", "getBlend_Red_6", "getBlend_Red_6$annotations", "Blend_Red_4_Light", "Blend_Red_4_Dark", "Blend_Red_4", "getBlend_Red_4", "getBlend_Red_4$annotations", "Blend_Fill_Element_2_Light", "Blend_Fill_Element_2_Dark", "Blend_Fill_Element_2", "getBlend_Fill_Element_2", "getBlend_Fill_Element_2$annotations", "Blend_Fluid_Thin_Light", "Blend_Fluid_Thin_Dark", "Blend_Fluid_Thin", "getBlend_Fluid_Thin", "getBlend_Fluid_Thin$annotations", "<init>", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class BlendToken {
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Base_Regular = null;
    public static final a[] Blend_Base_Regular_Dark = null;
    public static final a[] Blend_Base_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Base_Thick = null;
    public static final a[] Blend_Base_Thick_Dark = null;
    public static final a[] Blend_Base_Thick_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Blue_4 = null;
    public static final a[] Blend_Blue_4_Dark = null;
    public static final a[] Blend_Blue_4_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Blue_6 = null;
    public static final a[] Blend_Blue_6_Dark = null;
    public static final a[] Blend_Blue_6_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Fill_Element_2 = null;
    public static final a[] Blend_Fill_Element_2_Dark = null;
    public static final a[] Blend_Fill_Element_2_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Fluid_Thin = null;
    public static final a[] Blend_Fluid_Thin_Dark = null;
    public static final a[] Blend_Fluid_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Green_4 = null;
    public static final a[] Blend_Green_4_Dark = null;
    public static final a[] Blend_Green_4_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Green_6 = null;
    public static final a[] Blend_Green_6_Dark = null;
    public static final a[] Blend_Green_6_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Red_4 = null;
    public static final a[] Blend_Red_4_Dark = null;
    public static final a[] Blend_Red_4_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Red_6 = null;
    public static final a[] Blend_Red_6_Dark = null;
    public static final a[] Blend_Red_6_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Yellow_4 = null;
    public static final a[] Blend_Yellow_4_Dark = null;
    public static final a[] Blend_Yellow_4_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Yellow_6 = null;
    public static final a[] Blend_Yellow_6_Dark = null;
    public static final a[] Blend_Yellow_6_Light = null;
    public static final BlendToken INSTANCE = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Blue_Regular = null;
    public static final a[] OUI_Color_Blend_Blue_Regular_Dark = null;
    public static final a[] OUI_Color_Blend_Blue_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Blue_Thin = null;
    public static final a[] OUI_Color_Blend_Blue_Thin_Dark = null;
    public static final a[] OUI_Color_Blend_Blue_Thin_Light = null;
    public static final a[] OUI_Color_Blend_Fill_Tinted_Dark = null;
    public static final a[] OUI_Color_Blend_Fill_Tinted_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Fluid_Regular = null;
    public static final a[] OUI_Color_Blend_Fluid_Regular_Dark = null;
    public static final a[] OUI_Color_Blend_Fluid_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Fluid_Thick = null;
    public static final a[] OUI_Color_Blend_Fluid_Thick_Dark = null;
    public static final a[] OUI_Color_Blend_Fluid_Thick_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Fluid_Thin = null;
    public static final a[] OUI_Color_Blend_Fluid_Thin_Dark = null;
    public static final a[] OUI_Color_Blend_Fluid_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Fluid_UltraThin = null;
    public static final a[] OUI_Color_Blend_Fluid_UltraThin_Dark = null;
    public static final a[] OUI_Color_Blend_Fluid_UltraThin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Frost_Regular = null;
    public static final a[] OUI_Color_Blend_Frost_Regular_Dark = null;
    public static final a[] OUI_Color_Blend_Frost_Regular_Light = null;
    public static final a[] OUI_Color_Blend_Frost_Thick_Dark = null;
    public static final a[] OUI_Color_Blend_Frost_Thick_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Frost_Thin = null;
    public static final a[] OUI_Color_Blend_Frost_Thin_Dark = null;
    public static final a[] OUI_Color_Blend_Frost_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Frost_UltraThin = null;
    public static final a[] OUI_Color_Blend_Frost_UltraThin_Dark = null;
    public static final a[] OUI_Color_Blend_Frost_UltraThin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Green_Regular = null;
    public static final a[] OUI_Color_Blend_Green_Regular_Dark = null;
    public static final a[] OUI_Color_Blend_Green_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Green_Thin = null;
    public static final a[] OUI_Color_Blend_Green_Thin_Dark = null;
    public static final a[] OUI_Color_Blend_Green_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Red_Regular = null;
    public static final a[] OUI_Color_Blend_Red_Regular_Dark = null;
    public static final a[] OUI_Color_Blend_Red_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Red_Thin = null;
    public static final a[] OUI_Color_Blend_Red_Thin_Dark = null;
    public static final a[] OUI_Color_Blend_Red_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Text_Primary = null;
    public static final a[] OUI_Color_Blend_Text_Primary_Dark = null;
    public static final a[] OUI_Color_Blend_Text_Primary_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Text_Secondary = null;
    public static final a[] OUI_Color_Blend_Text_Secondary_Dark = null;
    public static final a[] OUI_Color_Blend_Text_Secondary_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Text_Tertiary = null;
    public static final a[] OUI_Color_Blend_Text_Tertiary_Dark = null;
    public static final a[] OUI_Color_Blend_Text_Tertiary_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Yellow_Regular = null;
    public static final a[] OUI_Color_Blend_Yellow_Regular_Dark = null;
    public static final a[] OUI_Color_Blend_Yellow_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Yellow_Thin = null;
    public static final a[] OUI_Color_Blend_Yellow_Thin_Dark = null;
    public static final a[] OUI_Color_Blend_Yellow_Thin_Light = null;
    public static final a[] OUI_Color_Fills_Thick_Dark = null;
    public static final a[] OUI_Color_Fills_Thick_Light = null;
    public static final a OUI_Color_State_Active_Dark = null;
    public static final a OUI_Color_State_Active_Light = null;
    public static final a OUI_Color_State_Press_Dark = null;
    public static final a OUI_Color_State_Press_Light = null;
    private static final Lazy providers$delegate = null;
    private static final Lazy tokens$delegate = null;

    private BlendToken() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Base_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Base_Thick$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Blue_4$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Blue_6$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Fill_Element_2$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Fluid_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Green_4$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Green_6$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Red_4$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Red_6$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Yellow_4$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Yellow_6$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Blue_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Blue_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Thick$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_UltraThin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Frost_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Frost_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Frost_UltraThin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Green_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Green_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Red_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Red_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Text_Primary$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Text_Secondary$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Text_Tertiary$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Yellow_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Yellow_Thin$annotations() {
    }

    static {
        INSTANCE = new BlendToken();
        tokens$delegate = LazyKt.lazy(BlendToken$tokens$2.INSTANCE);
        providers$delegate = LazyKt.lazy(BlendToken$providers$2.INSTANCE);
        BlendMode r3 = BlendMode.COLOR_DODGE;
        BlendMode r6 = BlendMode.SRC_OVER;
        Blend_Base_Thick_Light = new a[]{new a(-1726013665, r3), new a(-604571914, r6)};
        BlendMode r8 = BlendMode.COLOR_BURN;
        Blend_Base_Thick_Dark = new a[]{new a(-3355444, r8), new a(-618388444, r6)};
        Blend_Base_Thick = BlendToken$Blend_Base_Thick$1.INSTANCE;
        Blend_Base_Regular_Light = new a[]{new a(-14737633, r3), new a(-855638017, r6)};
        Blend_Base_Regular_Dark = new a[]{new a(-3355444, r8), new a(-666746302, r6)};
        Blend_Base_Regular = BlendToken$Blend_Base_Regular$1.INSTANCE;
        OUI_Color_Blend_Frost_Regular_Light = new a[]{new a(-14737633, r3), new a(-855638017, r6)};
        OUI_Color_Blend_Frost_Regular_Dark = new a[]{new a(-3355444, r8), new a(-868072894, r6)};
        OUI_Color_Blend_Frost_Regular = BlendToken$OUI_Color_Blend_Frost_Regular$1.INSTANCE;
        BlendMode r12 = BlendMode.LUMINOSITY;
        OUI_Color_Blend_Fluid_Regular_Light = new a[]{new a(1722987186, r12), new a(-13421773, r3), new a(872415231, r6)};
        OUI_Color_Blend_Fluid_Regular_Dark = new a[]{new a(-2137483112, r12), new a(-1716210508, r8), new a(352321535, r6)};
        OUI_Color_Blend_Fluid_Regular = BlendToken$OUI_Color_Blend_Fluid_Regular$1.INSTANCE;
        BlendMode r15 = BlendMode.PLUS_LIGHTER;
        OUI_Color_Blend_Frost_UltraThin_Light = new a[]{new a(-14737633, r15)};
        OUI_Color_Blend_Frost_UltraThin_Dark = new a[]{new a(-14737633, r15)};
        OUI_Color_Blend_Frost_UltraThin = BlendToken$OUI_Color_Blend_Frost_UltraThin$1.INSTANCE;
        OUI_Color_Blend_Fluid_UltraThin_Light = new a[]{new a(-15461356, r15)};
        OUI_Color_Blend_Fluid_UltraThin_Dark = new a[]{new a(-15461356, r15)};
        OUI_Color_Blend_Fluid_UltraThin = BlendToken$OUI_Color_Blend_Fluid_UltraThin$1.INSTANCE;
        OUI_Color_Blend_Frost_Thin_Light = new a[]{new a(1722329256, r12), new a(-13421773, r3), new a(-1711276033, r6)};
        OUI_Color_Blend_Frost_Thin_Dark = new a[]{new a(-2137417319, r12)};
        OUI_Color_Blend_Frost_Thin = BlendToken$OUI_Color_Blend_Frost_Thin$1.INSTANCE;
        OUI_Color_Blend_Fluid_Thin_Light = new a[]{new a(869059788, r12), new a(-1724697805, r3), new a(352321535, r6)};
        OUI_Color_Blend_Fluid_Thin_Dark = new a[]{new a(1721342361, r12)};
        OUI_Color_Blend_Fluid_Thin = BlendToken$OUI_Color_Blend_Fluid_Thin$1.INSTANCE;
        OUI_Color_Blend_Frost_Thick_Light = new a[]{new a(-1726013665, r3), new a(-604506121, r6)};
        OUI_Color_Blend_Frost_Thick_Dark = new a[]{new a(-3355444, r8), new a(-618059479, r6)};
        OUI_Color_Blend_Fluid_Thick_Light = new a[]{new a(-1726013665, r3), new a(-604506121, r6)};
        OUI_Color_Blend_Fluid_Thick_Dark = new a[]{new a(-858993460, r8), new a(-869717719, r6)};
        OUI_Color_Blend_Fluid_Thick = BlendToken$OUI_Color_Blend_Fluid_Thick$1.INSTANCE;
        OUI_Color_Fills_Thick_Light = new a[]{new a(251658240, r6)};
        OUI_Color_Fills_Thick_Dark = new a[]{new a(620756991, r6)};
        BlendMode r9 = BlendMode.PLUS_DARKER;
        OUI_Color_Blend_Text_Primary_Light = new a[]{new a(-13421773, r9)};
        OUI_Color_Blend_Text_Primary_Dark = new a[]{new a(-2500135, r15)};
        OUI_Color_Blend_Text_Primary = BlendToken$OUI_Color_Blend_Text_Primary$1.INSTANCE;
        OUI_Color_Blend_Text_Secondary_Light = new a[]{new a(-6710887, r9)};
        OUI_Color_Blend_Text_Secondary_Dark = new a[]{new a(-9211021, r15)};
        OUI_Color_Blend_Text_Secondary = BlendToken$OUI_Color_Blend_Text_Secondary$1.INSTANCE;
        OUI_Color_Blend_Text_Tertiary_Light = new a[]{new a(-4342339, r9)};
        OUI_Color_Blend_Text_Tertiary_Dark = new a[]{new a(-10921639, r15)};
        OUI_Color_Blend_Text_Tertiary = BlendToken$OUI_Color_Blend_Text_Tertiary$1.INSTANCE;
        BlendMode r14 = BlendMode.OVERLAY;
        OUI_Color_Blend_Fill_Tinted_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-1, r9)};
        OUI_Color_Blend_Fill_Tinted_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-16777216, r9)};
        OUI_Color_Blend_Blue_Thin_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-10049793, r9)};
        OUI_Color_Blend_Blue_Thin_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-10049793, r9)};
        OUI_Color_Blend_Blue_Thin = BlendToken$OUI_Color_Blend_Blue_Thin$1.INSTANCE;
        OUI_Color_Blend_Blue_Regular_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-14253569, r9)};
        OUI_Color_Blend_Blue_Regular_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-14253569, r9)};
        OUI_Color_Blend_Blue_Regular = BlendToken$OUI_Color_Blend_Blue_Regular$1.INSTANCE;
        OUI_Color_Blend_Red_Thin_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-30841, r9)};
        OUI_Color_Blend_Red_Thin_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-30841, r9)};
        OUI_Color_Blend_Red_Thin = BlendToken$OUI_Color_Blend_Red_Thin$1.INSTANCE;
        OUI_Color_Blend_Red_Regular_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-45747, r9)};
        OUI_Color_Blend_Red_Regular_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-45747, r9)};
        OUI_Color_Blend_Red_Regular = BlendToken$OUI_Color_Blend_Red_Regular$1.INSTANCE;
        OUI_Color_Blend_Green_Thin_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-8917601, r9)};
        OUI_Color_Blend_Green_Thin_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-8917601, r9)};
        OUI_Color_Blend_Green_Thin = BlendToken$OUI_Color_Blend_Green_Thin$1.INSTANCE;
        OUI_Color_Blend_Green_Regular_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-15415472, r9)};
        OUI_Color_Blend_Green_Regular_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-15415472, r9)};
        OUI_Color_Blend_Green_Regular = BlendToken$OUI_Color_Blend_Green_Regular$1.INSTANCE;
        OUI_Color_Blend_Yellow_Thin_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-11671, r9)};
        OUI_Color_Blend_Yellow_Thin_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-11671, r9)};
        OUI_Color_Blend_Yellow_Thin = BlendToken$OUI_Color_Blend_Yellow_Thin$1.INSTANCE;
        OUI_Color_Blend_Yellow_Regular_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-15078, r9)};
        OUI_Color_Blend_Yellow_Regular_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-15078, r9)};
        OUI_Color_Blend_Yellow_Regular = BlendToken$OUI_Color_Blend_Yellow_Regular$1.INSTANCE;
        OUI_Color_State_Press_Light = new a(-13421773, r15);
        OUI_Color_State_Press_Dark = new a(-1724697805, r15);
        OUI_Color_State_Active_Light = new a(-6710887, r15);
        OUI_Color_State_Active_Dark = new a(-6710887, r15);
        Blend_Blue_6_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-15042049, r9)};
        Blend_Blue_6_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-15042049, r9)};
        Blend_Blue_6 = BlendToken$Blend_Blue_6$1.INSTANCE;
        Blend_Blue_4_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-10049793, r9)};
        Blend_Blue_4_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-10049793, r9)};
        Blend_Blue_4 = BlendToken$Blend_Blue_4$1.INSTANCE;
        Blend_Yellow_6_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-873984, r9)};
        Blend_Yellow_6_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-873984, r9)};
        Blend_Yellow_6 = BlendToken$Blend_Yellow_6$1.INSTANCE;
        Blend_Yellow_4_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-11671, r9)};
        Blend_Yellow_4_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-11671, r9)};
        Blend_Yellow_4 = BlendToken$Blend_Yellow_4$1.INSTANCE;
        Blend_Green_6_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-16722873, r9)};
        Blend_Green_6_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-16722873, r9)};
        Blend_Green_6 = BlendToken$Blend_Green_6$1.INSTANCE;
        Blend_Green_4_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-8917601, r9)};
        Blend_Green_4_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-8917601, r9)};
        Blend_Green_4 = BlendToken$Blend_Green_4$1.INSTANCE;
        Blend_Red_6_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-53971, r9)};
        Blend_Red_6_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-53971, r9)};
        Blend_Red_6 = BlendToken$Blend_Red_6$1.INSTANCE;
        Blend_Red_4_Light = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-30841, r9)};
        Blend_Red_4_Dark = new a[]{new a(-2130706433, r6), new a(-3355444, r14), new a(-30841, r9)};
        Blend_Red_4 = BlendToken$Blend_Red_4$1.INSTANCE;
        Blend_Fill_Element_2_Light = new a[]{new a(167772160, r6)};
        Blend_Fill_Element_2_Dark = new a[]{new a(536870911, r6)};
        Blend_Fill_Element_2 = BlendToken$Blend_Fill_Element_2$1.INSTANCE;
        Blend_Fluid_Thin_Light = new a[]{new a(-13421773, r3), new a(1088018905, r6)};
        Blend_Fluid_Thin_Dark = new a[]{new a(-13421773, r3), new a(1088018905, r6)};
        Blend_Fluid_Thin = BlendToken$Blend_Fluid_Thin$1.INSTANCE;
    }

    private final ConcurrentHashMap<String, kotlin.jvm.functions.Function1<Boolean, a[]>> getProviders() {
        return (ConcurrentHashMap) providers$delegate.getValue();
    }

    private final ConcurrentHashMap<String, a[]> getTokens() {
        return (ConcurrentHashMap) tokens$delegate.getValue();
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Base_Regular() {
        return Blend_Base_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Base_Thick() {
        return Blend_Base_Thick;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Blue_4() {
        return Blend_Blue_4;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Blue_6() {
        return Blend_Blue_6;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Fill_Element_2() {
        return Blend_Fill_Element_2;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Fluid_Thin() {
        return Blend_Fluid_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Green_4() {
        return Blend_Green_4;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Green_6() {
        return Blend_Green_6;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Red_4() {
        return Blend_Red_4;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Red_6() {
        return Blend_Red_6;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Yellow_4() {
        return Blend_Yellow_4;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Yellow_6() {
        return Blend_Yellow_6;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Blue_Regular() {
        return OUI_Color_Blend_Blue_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Blue_Thin() {
        return OUI_Color_Blend_Blue_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Fluid_Regular() {
        return OUI_Color_Blend_Fluid_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Fluid_Thick() {
        return OUI_Color_Blend_Fluid_Thick;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Fluid_Thin() {
        return OUI_Color_Blend_Fluid_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Fluid_UltraThin() {
        return OUI_Color_Blend_Fluid_UltraThin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Frost_Regular() {
        return OUI_Color_Blend_Frost_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Frost_Thin() {
        return OUI_Color_Blend_Frost_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Frost_UltraThin() {
        return OUI_Color_Blend_Frost_UltraThin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Green_Regular() {
        return OUI_Color_Blend_Green_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Green_Thin() {
        return OUI_Color_Blend_Green_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Red_Regular() {
        return OUI_Color_Blend_Red_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Red_Thin() {
        return OUI_Color_Blend_Red_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Text_Primary() {
        return OUI_Color_Blend_Text_Primary;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Text_Secondary() {
        return OUI_Color_Blend_Text_Secondary;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Text_Tertiary() {
        return OUI_Color_Blend_Text_Tertiary;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Yellow_Regular() {
        return OUI_Color_Blend_Yellow_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Yellow_Thin() {
        return OUI_Color_Blend_Yellow_Thin;
    }

    @JvmStatic
    public static final kotlin.jvm.functions.Function1<Boolean, a[]> parse(String r1) {
        int r0 = com.obric.oui.material.r.a;
        return (kotlin.jvm.functions.Function1) com.obric.oui.material.r.a(r1, INSTANCE.getProviders());
    }

    @JvmStatic
    public static final a[] parse(String r2, boolean r3) {
        int r0 = com.obric.oui.material.r.a;
        BlendToken r1 = INSTANCE;
        if (((a[]) com.obric.oui.material.r.a(r2, r1.getTokens())) != null) goto L9;
        if (r3 == false) goto L6;
        String r4 = "_light";
    L7:
        a[] r5 = (a[]) com.obric.oui.material.r.a(Intrinsics.stringPlus(r2, r4), r1.getTokens());
        goto L9
    L6:
        r4 = "_dark";
    L9:
        return (a[]) com.obric.oui.material.r.a(r2, r1.getTokens());
    }

    @JvmStatic
    public static final void register(Object r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "customTokenOwner");
        int r0 = com.obric.oui.material.r.a;
        ConcurrentHashMap<String, a[]> r1 = INSTANCE.getTokens();
        LinkedHashMap r2 = new LinkedHashMap();
        Field[] r3 = r9.getClass().getDeclaredFields();     // Catch: Exception -> L11
        int r4 = r3.length;     // Catch: Exception -> L11
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L12;
        Field r6 = r3[r5];     // Catch: Exception -> L11
        r5 = r5 + 1;     // Catch: Exception -> L11
        if (a[].class.isAssignableFrom(r6.getType()) == false) goto L4;
        r6.setAccessible(true);     // Catch: Exception -> L11
        Object r7 = r6.get(r9);     // Catch: Exception -> L11
        if ((r7 instanceof a[]) == false) goto L4;
        r2.put(r6.getName().toLowerCase(Locale.ROOT), r7);     // Catch: Exception -> L11
    L12:
        com.obric.oui.material.r.b(r1, r2, r10);
        return;
    L11:
        Intrinsics.stringPlus("Failed to parse tokens from ", r9.getClass().getSimpleName());
        goto L12
    }

    @JvmStatic
    public static final void registerProvider(Object r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "customTokenOwner");
        int r0 = com.obric.oui.material.r.a;
        ConcurrentHashMap<String, kotlin.jvm.functions.Function1<Boolean, a[]>> r1 = INSTANCE.getProviders();
        LinkedHashMap r2 = new LinkedHashMap();
        Field[] r3 = r9.getClass().getDeclaredFields();     // Catch: Exception -> L11
        int r4 = r3.length;     // Catch: Exception -> L11
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L12;
        Field r6 = r3[r5];     // Catch: Exception -> L11
        r5 = r5 + 1;     // Catch: Exception -> L11
        if (kotlin.jvm.functions.Function1.class.isAssignableFrom(r6.getType()) == false) goto L4;
        r6.setAccessible(true);     // Catch: Exception -> L11
        Object r8 = r6.get(r9);     // Catch: Exception -> L11
        if (TypeIntrinsics.isFunctionOfArity(r8, 1) == false) goto L4;
        r2.put(r6.getName().toLowerCase(Locale.ROOT), r8);     // Catch: Exception -> L11
    L12:
        com.obric.oui.material.r.b(r1, r2, r10);
        return;
    L11:
        Intrinsics.stringPlus("Failed to parse tokens from ", r9.getClass().getSimpleName());
        goto L12
    }

    @JvmStatic
    public static final void registerProviderTokens(Map<String, ? extends kotlin.jvm.functions.Function1<? super Boolean, a[]>> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "customTokens");
        int r0 = com.obric.oui.material.r.a;
        com.obric.oui.material.r.b(INSTANCE.getProviders(), r1, r2);
    }

    @JvmStatic
    public static final void registerTokens(Map<String, a[]> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "customTokens");
        int r0 = com.obric.oui.material.r.a;
        com.obric.oui.material.r.b(INSTANCE.getTokens(), r1, r2);
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    public static /* synthetic */ void registerProvider$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerProvider(r0, r1);
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerProviderTokens(r0, r1);
    }

    public static /* synthetic */ void registerTokens$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerTokens(r0, r1);
    }
}
