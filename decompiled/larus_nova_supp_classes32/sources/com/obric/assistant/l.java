package com.obric.assistant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l {
    public static final OUseMemorySettingsConfig a = null;
    public static final List<ComplexTaskSettingsCommonItem> b = null;
    public static final List<ComplexTaskSettingsCommonItem> c = null;
    public static final ComplexTaskSettingsConfig d = null;
    public static final ObricSettingsListConfig e = null;
    public static final List<String> f = null;
    public static final List<String> g = null;
    public static final List<String> h = null;
    public static final ObricActionBarItemsConfig i = null;
    public static final ObricActionBarItemsConfig j = null;
    public static final ObricActionBarModelMenuConfig k = null;
    public static final ObricBottomTabConfig l = null;
    public static final ObricDeepThinkModeRestTimeConfig m = null;
    public static final q1 n = null;
    public static final ObricAsrFeedbackConfig o = null;
    public static final ObricContTalkConfig p = null;

    static {
        a = new OUseMemorySettingsConfig(true);
        List<ComplexTaskSettingsCommonItem> r4 = CollectionsKt.listOf(new ComplexTaskSettingsCommonItem[]{new ComplexTaskSettingsCommonItem(1, "react", "React"), new ComplexTaskSettingsCommonItem(2, "planexecute", "Plan+execute")});
        b = r4;
        List<ComplexTaskSettingsCommonItem> r2 = CollectionsKt.listOf(new ComplexTaskSettingsCommonItem[]{new ComplexTaskSettingsCommonItem(1, "gpt-41", "GPT-4.1"), new ComplexTaskSettingsCommonItem(2, "claude-37", "Claude-3.7"), new ComplexTaskSettingsCommonItem(3, "claude-4", "Claude-4"), new ComplexTaskSettingsCommonItem(4, "doubao-16-sft", "豆包模型 (Beta)")});
        c = r2;
        d = new ComplexTaskSettingsConfig("planexecute", "claude-37", r4, r2);
        e = new ObricSettingsListConfig(null, null);
        List<String> r3 = CollectionsKt.listOf(new String[]{"11757434315683330", "295367523", "1890683158", "780021240", "-761162256", "1439177079459842", "261510651735810", "261510651736322", "261510651731202", "11757415837603330", "261510651733762", "261510651740418", "857401409443330", "3104653159767042", "261510651737858", "261510651739906", "21554838808483330", "261510651730434", "6158051860028162", "261510651732994", "241623133", "596623375", "-92001", "40171075925118466"});
        f = r3;
        g = CollectionsKt.listOf(new String[]{"295367523", "1890683158", "780021240", "-761162256", "241623133", "1439177079459842", "596623375", "-92001", "40171075925118466", "-93000"});
        h = CollectionsKt.listOf("13090563690403330");
        List<String> r5 = r3;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r8.add(new q0((String) r6.next()));
        goto L4
    L6:
        i = new ObricActionBarItemsConfig(null, r8, 1, null);
        List<String> r7 = g;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r10 = r7.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r9.add(new q0((String) r10.next()));
        goto L8
    L10:
        j = new ObricActionBarItemsConfig(null, r9, 1, null);
        k = new ObricActionBarModelMenuConfig(Boolean.TRUE, CollectionsKt.listOf(new Integer[]{2, 3, 10000, 100001}), 4);
        l = new ObricBottomTabConfig(null, null, null, 7, null);
        m = new ObricDeepThinkModeRestTimeConfig(1200000L);
        Boolean r1 = Boolean.FALSE;
        n = new q1(r1);
        o = new ObricAsrFeedbackConfig(r1);
        p = new ObricContTalkConfig(r1);
    }
}
