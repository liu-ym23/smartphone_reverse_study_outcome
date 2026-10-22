package com.larus.business.markdown.impl.common.utils;

import android.app.Application;
import android.content.res.Resources;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0010\b\n\u0003\b\u008b\u0001\u001a\u0012\u0010\u008a\u0001\u001a\u00020\u00012\t\b\u0001\u0010\u008b\u0001\u001a\u00020\u0001\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0006\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\u0007\u0010\u0003\"\u001b\u0010\t\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\n\u0010\u0003\"\u001b\u0010\f\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\r\u0010\u0003\"\u001b\u0010\u000f\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0010\u0010\u0003\"\u001b\u0010\u0012\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0013\u0010\u0003\"\u001b\u0010\u0015\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0016\u0010\u0003\"\u001b\u0010\u0018\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u0019\u0010\u0003\"\u001b\u0010\u001b\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001c\u0010\u0003\"\u001b\u0010\u001e\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b\u001f\u0010\u0003\"\u001b\u0010!\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b\"\u0010\u0003\"\u001b\u0010$\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b%\u0010\u0003\"\u001b\u0010'\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b(\u0010\u0003\"\u001b\u0010*\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0005\u001a\u0004\b+\u0010\u0003\"\u001b\u0010-\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0005\u001a\u0004\b.\u0010\u0003\"\u001b\u00100\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b1\u0010\u0003\"\u001b\u00103\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0005\u001a\u0004\b4\u0010\u0003\"\u001b\u00106\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0005\u001a\u0004\b7\u0010\u0003\"\u001b\u00109\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0005\u001a\u0004\b:\u0010\u0003\"\u001b\u0010<\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0005\u001a\u0004\b=\u0010\u0003\"\u001b\u0010?\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0005\u001a\u0004\b@\u0010\u0003\"\u001b\u0010B\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0005\u001a\u0004\bC\u0010\u0003\"\u001b\u0010E\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0005\u001a\u0004\bF\u0010\u0003\"\u001b\u0010H\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0005\u001a\u0004\bI\u0010\u0003\"\u001b\u0010K\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0005\u001a\u0004\bL\u0010\u0003\"\u001b\u0010N\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0005\u001a\u0004\bO\u0010\u0003\"\u001b\u0010Q\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u0005\u001a\u0004\bR\u0010\u0003\"\u001b\u0010T\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0005\u001a\u0004\bU\u0010\u0003\"\u001b\u0010W\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0005\u001a\u0004\bX\u0010\u0003\"\u001b\u0010Z\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u0005\u001a\u0004\b[\u0010\u0003\"\u001b\u0010]\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\u0005\u001a\u0004\b^\u0010\u0003\"\u001b\u0010`\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u0005\u001a\u0004\ba\u0010\u0003\"\u001b\u0010c\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u0005\u001a\u0004\bd\u0010\u0003\"\u001b\u0010f\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\u0005\u001a\u0004\bg\u0010\u0003\"\u001b\u0010i\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\u0005\u001a\u0004\bj\u0010\u0003\"\u001b\u0010l\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bn\u0010\u0005\u001a\u0004\bm\u0010\u0003\"\u001b\u0010o\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bq\u0010\u0005\u001a\u0004\bp\u0010\u0003\"\u001b\u0010r\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\u0005\u001a\u0004\bs\u0010\u0003\"\u001b\u0010u\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bw\u0010\u0005\u001a\u0004\bv\u0010\u0003\"\u001b\u0010x\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bz\u0010\u0005\u001a\u0004\by\u0010\u0003\"\u001b\u0010{\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b}\u0010\u0005\u001a\u0004\b|\u0010\u0003\"\u001c\u0010~\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\r\n\u0005\b\u0080\u0001\u0010\u0005\u001a\u0004\b\u007f\u0010\u0003\"\u001e\u0010\u0081\u0001\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010\u0005\u001a\u0005\b\u0082\u0001\u0010\u0003\"\u001e\u0010\u0084\u0001\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u0005\u001a\u0005\b\u0085\u0001\u0010\u0003\"\u001e\u0010\u0087\u0001\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010\u0005\u001a\u0005\b\u0088\u0001\u0010\u0003¨\u0006\u008c\u0001"}, d2 = {"dp_0_5", "", "getDp_0_5", "()I", "dp_0_5$delegate", "Lkotlin/Lazy;", "dp_1", "getDp_1", "dp_1$delegate", "dp_10", "getDp_10", "dp_10$delegate", "dp_104", "getDp_104", "dp_104$delegate", "dp_11", "getDp_11", "dp_11$delegate", "dp_12", "getDp_12", "dp_12$delegate", "dp_120", "getDp_120", "dp_120$delegate", "dp_122", "getDp_122", "dp_122$delegate", "dp_14", "getDp_14", "dp_14$delegate", "dp_146", "getDp_146", "dp_146$delegate", "dp_16", "getDp_16", "dp_16$delegate", "dp_164", "getDp_164", "dp_164$delegate", "dp_17", "getDp_17", "dp_17$delegate", "dp_18", "getDp_18", "dp_18$delegate", "dp_180", "getDp_180", "dp_180$delegate", "dp_19", "getDp_19", "dp_19$delegate", "dp_2", "getDp_2", "dp_2$delegate", "dp_20", "getDp_20", "dp_20$delegate", "dp_200", "getDp_200", "dp_200$delegate", "dp_22", "getDp_22", "dp_22$delegate", "dp_24", "getDp_24", "dp_24$delegate", "dp_250", "getDp_250", "dp_250$delegate", "dp_28", "getDp_28", "dp_28$delegate", "dp_294", "getDp_294", "dp_294$delegate", "dp_3", "getDp_3", "dp_3$delegate", "dp_32", "getDp_32", "dp_32$delegate", "dp_330", "getDp_330", "dp_330$delegate", "dp_34", "getDp_34", "dp_34$delegate", "dp_36", "getDp_36", "dp_36$delegate", "dp_375", "getDp_375", "dp_375$delegate", "dp_4", "getDp_4", "dp_4$delegate", "dp_40", "getDp_40", "dp_40$delegate", "dp_44", "getDp_44", "dp_44$delegate", "dp_45", "getDp_45", "dp_45$delegate", "dp_48", "getDp_48", "dp_48$delegate", "dp_5", "getDp_5", "dp_5$delegate", "dp_50", "getDp_50", "dp_50$delegate", "dp_52", "getDp_52", "dp_52$delegate", "dp_56", "getDp_56", "dp_56$delegate", "dp_58", "getDp_58", "dp_58$delegate", "dp_6", "getDp_6", "dp_6$delegate", "dp_60", "getDp_60", "dp_60$delegate", "dp_70", "getDp_70", "dp_70$delegate", "dp_76", "getDp_76", "dp_76$delegate", "dp_8", "getDp_8", "dp_8$delegate", "resDimensionPixelSize", OaidModel.KEY_ID, "markdown-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class c {
    private static final Lazy A = null;
    private static final Lazy B = null;
    private static final Lazy C = null;
    private static final Lazy D = null;
    private static final Lazy E = null;
    private static final Lazy F = null;
    private static final Lazy G = null;
    private static final Lazy H = null;
    private static final Lazy I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final Lazy f5177J = null;
    private static final Lazy K = null;
    private static final Lazy L = null;
    private static final Lazy M = null;
    private static final Lazy N = null;
    private static final Lazy O = null;
    private static final Lazy P = null;
    private static final Lazy Q = null;
    private static final Lazy R = null;
    private static final Lazy S = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f5178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f5179b = null;
    private static final Lazy c = null;
    private static final Lazy d = null;
    private static final Lazy e = null;
    private static final Lazy f = null;
    private static final Lazy g = null;
    private static final Lazy h = null;
    private static final Lazy i = null;
    private static final Lazy j = null;
    private static final Lazy k = null;
    private static final Lazy l = null;
    private static final Lazy m = null;
    private static final Lazy n = null;
    private static final Lazy o = null;
    private static final Lazy p = null;
    private static final Lazy q = null;
    private static final Lazy r = null;
    private static final Lazy s = null;
    private static final Lazy t = null;
    private static final Lazy u = null;
    private static final Lazy v = null;
    private static final Lazy w = null;
    private static final Lazy x = null;
    private static final Lazy y = null;
    private static final Lazy z = null;

    static {
        f5178a = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_0_5$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        f5179b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_1$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_2$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_3$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_4$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        f = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_5$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_6$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        h = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_8$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        i = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_10$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        j = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_11$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        k = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_12$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        l = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_14$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        m = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_16$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        n = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_17$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        o = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_18$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        p = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_19$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        q = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_20$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        r = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_22$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        s = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_24$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        t = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_28$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        u = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_32$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        v = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_34$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        w = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_36$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        x = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_40$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        y = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_44$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        z = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_45$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        A = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_48$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        B = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_50$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        C = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_52$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        D = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_56$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        E = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_58$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        F = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_60$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        G = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_70$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        H = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_76$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        I = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_104$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        f5177J = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_120$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        K = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_122$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        L = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_146$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        M = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_164$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        N = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_180$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        O = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_200$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        P = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_250$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        Q = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_294$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        R = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_330$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        S = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownDimensExtKt$dp_375$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final int a() {
        return ((Number) ZeusTransformUtils.preCheckCast(f5179b.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int a(int r3) {
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.larus.business.markdown.api.a.f5138a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        Resources r1 = ZeusTransformUtils.getResources(r0, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        return r1.getDimensionPixelSize(r3);
    L7:
        return 0;
    }

    public static final int b() {
        return ((Number) ZeusTransformUtils.preCheckCast(d.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int c() {
        return ((Number) ZeusTransformUtils.preCheckCast(e.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int d() {
        return ((Number) ZeusTransformUtils.preCheckCast(k.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int e() {
        return ((Number) ZeusTransformUtils.preCheckCast(l.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int f() {
        return ((Number) ZeusTransformUtils.preCheckCast(m.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int g() {
        return ((Number) ZeusTransformUtils.preCheckCast(n.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int h() {
        return ((Number) ZeusTransformUtils.preCheckCast(p.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int i() {
        return ((Number) ZeusTransformUtils.preCheckCast(q.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int j() {
        return ((Number) ZeusTransformUtils.preCheckCast(f5177J.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int k() {
        return ((Number) ZeusTransformUtils.preCheckCast(N.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int l() {
        return ((Number) ZeusTransformUtils.preCheckCast(S.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }
}
