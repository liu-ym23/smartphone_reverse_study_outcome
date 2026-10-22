package com.bytedance.ai.uiu.objects;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/uiu/objects/UIOperationDef;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum UIOperationDef extends Enum<UIOperationDef> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UIOperationDef f2832b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final UIOperationDef f2833c = null;
    public static final UIOperationDef d = null;
    public static final UIOperationDef e = null;
    public static final UIOperationDef f = null;
    public static final UIOperationDef g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final UIOperationDef f2834h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final UIOperationDef f2835i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ UIOperationDef[] f2836j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2837a;

    static {
        UIOperationDef r5 = new UIOperationDef("CLICK", 0, "click");
        f2832b = r5;
        UIOperationDef r10 = new UIOperationDef("LONG_CLICK", 1, "longClick");
        f2833c = r10;
        UIOperationDef r11 = new UIOperationDef("INPUT", 2, "input");
        d = r11;
        UIOperationDef r12 = new UIOperationDef("INPUT_GO", 3, "inputGo");
        e = r12;
        UIOperationDef r13 = new UIOperationDef("SCROLL_BOTTOM", 4, "scrollBottom");
        f = r13;
        UIOperationDef r14 = new UIOperationDef("SCROLL_NEXT", 5, "scrollNext");
        g = r14;
        UIOperationDef r15 = new UIOperationDef("SCROLL_PREVIOUS", 6, "scrollPrevious");
        f2834h = r15;
        UIOperationDef r16 = new UIOperationDef("SCROLL_TOP", 7, "scrollTop");
        f2835i = r16;
        UIOperationDef[] r17 = {r5, r10, r11, r12, r13, r14, r15, r16};
        f2836j = r17;
        EnumEntriesKt.enumEntries(r17);
    }

    public UIOperationDef(String r5, int r10, String r11) {
        super(r5, r10);
        this.f2837a = r11;
    }

    public static UIOperationDef valueOf(String r5) {
        return (UIOperationDef) Enum.valueOf(UIOperationDef.class, r5);
    }

    public static UIOperationDef[] values() {
        return (UIOperationDef[]) f2836j.clone();
    }
}
