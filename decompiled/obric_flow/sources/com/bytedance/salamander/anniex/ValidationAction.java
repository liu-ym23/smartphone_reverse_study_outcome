package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/salamander/anniex/ValidationAction;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ValidationAction extends Enum<ValidationAction> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ValidationAction f7235a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ValidationAction f7236b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ValidationAction f7237c = null;
    public static final ValidationAction d = null;
    public static final /* synthetic */ ValidationAction[] e = null;

    static {
        ValidationAction r5 = new ValidationAction("Exception", 0);
        f7235a = r5;
        ValidationAction r10 = new ValidationAction("Discard", 1);
        f7236b = r10;
        ValidationAction r11 = new ValidationAction("CutOff", 2);
        f7237c = r11;
        ValidationAction r12 = new ValidationAction("None", 3);
        d = r12;
        e = new ValidationAction[]{r5, r10, r11, r12};
    }

    public ValidationAction(String r5, int r10) {
        super(r5, r10);
    }

    public static ValidationAction valueOf(String r5) {
        return (ValidationAction) Enum.valueOf(ValidationAction.class, r5);
    }

    public static ValidationAction[] values() {
        return (ValidationAction[]) e.clone();
    }
}
