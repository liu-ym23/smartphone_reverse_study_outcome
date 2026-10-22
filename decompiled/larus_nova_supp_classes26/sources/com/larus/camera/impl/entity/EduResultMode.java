package com.larus.camera.impl.entity;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import nx8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0012"}, d2 = {"Lcom/larus/camera/impl/entity/EduResultMode;", "", "textResId", "", "clipViewMode", "Lcom/larus/camera/impl/edulibs/cameraapi/EduClipViewMode;", "<init>", "(Ljava/lang/String;IILcom/larus/camera/impl/edulibs/cameraapi/EduClipViewMode;)V", "getTextResId", "()I", "getClipViewMode", "()Lcom/larus/camera/impl/edulibs/cameraapi/EduClipViewMode;", "SINGLE_QUESTION", "MULTI_QUESTION", "HOMEWORK_CORRECTION", "PHOTO", "toEduIntentMode", "Lcom/larus/camera/impl/entity/EduIntentMode;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EduResultMode extends Enum<EduResultMode> {
    public static final EduResultMode HOMEWORK_CORRECTION = null;
    public static final EduResultMode MULTI_QUESTION = null;
    public static final EduResultMode PHOTO = null;
    public static final EduResultMode SINGLE_QUESTION = null;
    public static final /* synthetic */ EduResultMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final c clipViewMode;
    private final int textResId;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EduResultMode.values().length];
            r0[EduResultMode.SINGLE_QUESTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[EduResultMode.MULTI_QUESTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[EduResultMode.HOMEWORK_CORRECTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[EduResultMode.PHOTO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static EnumEntries<EduResultMode> getEntries() {
        return b;
    }

    static {
        EduResultMode r0 = new EduResultMode("SINGLE_QUESTION", 0, 2131900562, c.C0123c.a);
        SINGLE_QUESTION = r0;
        EduResultMode r1 = new EduResultMode("MULTI_QUESTION", 1, 2131900559, c.b.a);
        MULTI_QUESTION = r1;
        c.a r3 = c.a.a;
        EduResultMode r2 = new EduResultMode("HOMEWORK_CORRECTION", 2, 2131899419, r3);
        HOMEWORK_CORRECTION = r2;
        EduResultMode r5 = new EduResultMode("PHOTO", 3, 2131900561, r3);
        PHOTO = r5;
        EduResultMode[] r4 = {r0, r1, r2, r5};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static EduResultMode[] values() {
        return (EduResultMode[]) a.clone();
    }

    public final EduIntentMode toEduIntentMode() {
        int r0 = a.a[ordinal()];
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L18;
        if (r0 != 4) goto L12;
        return EduIntentMode.COMMON;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return EduIntentMode.HOMEWORK_CORRECTION;
    L19:
        return EduIntentMode.MULTI_QUESTION;
    L16:
        return EduIntentMode.SINGLE_QUESTION;
    }

    public final c getClipViewMode() {
        return this.clipViewMode;
    }

    public final int getTextResId() {
        return this.textResId;
    }

    public static EduResultMode valueOf(String r1) {
        return (EduResultMode) r27.a.a(EduResultMode.class, r1);
    }

    public EduResultMode(String r1, int r2, int r3, c r4) {
        super(r1, r2);
        this.textResId = r3;
        this.clipViewMode = r4;
    }
}
