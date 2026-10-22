package com.bytedance.android.livesdk.followtool.utils;

import com.bytedance.android.live.core.utils.g2;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class XTFollowSyncPrefs extends g2 {
    public static final /* synthetic */ KProperty[] c = null;
    public static final g2.d d = null;
    public static final g2.c e = null;
    public static final g2.d f = null;
    public static final g2.c g = null;
    public static final g2.d h = null;
    public static final g2.f i = null;
    public static final g2.b j = null;
    public static final g2.d k = null;
    public static final g2.e l = null;
    public static final XTFollowSyncPrefs m = null;

    public XTFollowSyncPrefs() {
        super(null, AnonymousClass1.INSTANCE);
    }

    public final int b() {
        return ((Number) e.b(c[1])).intValue();
    }

    public final int c() {
        return ((Number) f.b(c[2])).intValue();
    }

    public final int d() {
        return ((Number) g.b(c[3])).intValue();
    }

    public final int e() {
        return ((Number) h.b(c[4])).intValue();
    }

    static {
        c = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "syncFollowSucToastCnt", "getSyncFollowSucToastCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "anchorDialogCntToday", "getAnchorDialogCntToday()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "anchorDialogCntTotal", "getAnchorDialogCntTotal()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "followDialogCntToday", "getFollowDialogCntToday()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "followDialogCntTotal", "getFollowDialogCntTotal()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "followDialogCntWeek", "getFollowDialogCntWeek()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "followDialogCntReset", "getFollowDialogCntReset()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "followRelationsDialogCnt", "getFollowRelationsDialogCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "followRelationsDialogCntWeekDays", "getFollowRelationsDialogCntWeekDays()I", 0))};
        XTFollowSyncPrefs r0 = new XTFollowSyncPrefs();
        m = r0;
        d = new g2.d(r0, "sync_follow_suc_cnt", 0);
        e = new g2.c(r0, "anchor_dialog_cnt_today", 0);
        f = new g2.d(r0, "anchor_dialog_cnt_total", 0);
        g = new g2.c(r0, "follow_dialog_cnt_today", 0);
        h = new g2.d(r0, "follow_dialog_cnt_total", 0);
        i = new g2.f(r0, 0);
        j = new g2.b(r0, "follow_dialog_cnt_reset", 0);
        k = new g2.d(r0, "follow_relations_dialog_cnt", 0);
        l = new g2.e(r0, 0);
    }
}
