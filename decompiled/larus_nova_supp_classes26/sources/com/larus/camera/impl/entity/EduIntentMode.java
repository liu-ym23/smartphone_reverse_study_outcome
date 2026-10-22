package com.larus.camera.impl.entity;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import nx8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/larus/camera/impl/entity/EduIntentMode;", "", "id", "", "textResId", "clipViewMode", "Lcom/larus/camera/impl/edulibs/cameraapi/EduClipViewMode;", "<init>", "(Ljava/lang/String;IIILcom/larus/camera/impl/edulibs/cameraapi/EduClipViewMode;)V", "getId", "()I", "getTextResId", "getClipViewMode", "()Lcom/larus/camera/impl/edulibs/cameraapi/EduClipViewMode;", "UNDETECTED", "COMMON", "SINGLE_QUESTION", "MULTI_QUESTION", "HOMEWORK_CORRECTION", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EduIntentMode extends Enum<EduIntentMode> {
    public static final EduIntentMode COMMON = null;
    public static final a Companion = null;
    public static final EduIntentMode HOMEWORK_CORRECTION = null;
    public static final EduIntentMode MULTI_QUESTION = null;
    public static final EduIntentMode SINGLE_QUESTION = null;
    public static final EduIntentMode UNDETECTED = null;
    public static final /* synthetic */ EduIntentMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final c clipViewMode;
    private final int id;
    private final int textResId;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.camera.impl.entity.EduIntentMode$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0077a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[EduIntentMode.values().length];
                r0[EduIntentMode.UNDETECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[EduIntentMode.COMMON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[EduIntentMode.SINGLE_QUESTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[EduIntentMode.MULTI_QUESTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[EduIntentMode.HOMEWORK_CORRECTION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        public a() {
        }

        public static EduIntentMode a(int r2) {
            EduIntentMode r0 = EduIntentMode.SINGLE_QUESTION;
            if (r2 == r0.getId()) goto L16;
            EduIntentMode r1 = EduIntentMode.MULTI_QUESTION;
            if (r2 == r1.getId()) goto L17;
            EduIntentMode r3 = EduIntentMode.COMMON;
            if (r2 == r3.getId()) goto L18;
            EduIntentMode r4 = EduIntentMode.HOMEWORK_CORRECTION;
            if (r2 != r4.getId()) goto L15;
            return r4;
        L15:
            return EduIntentMode.UNDETECTED;
        L18:
            return r3;
        L17:
            return r1;
        L16:
            return r0;
        }

        public static int b(EduIntentMode r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            int r3 = C0077a.a[r2.ordinal()];
            if (r3 != 1) goto L5;
            return 0;
        L5:
            if (r3 != 2) goto L7;
            return 1;
        L7:
            if (r3 != 3) goto L9;
        L15:
            return 2;
        L9:
            if (r3 == 4) goto L15;
            if (r3 == 5) goto L15;
            throw new NoWhenBranchMatchedException();
        }
    }

    public static EnumEntries<EduIntentMode> getEntries() {
        return b;
    }

    static {
        c.a r13 = c.a.a;
        EduIntentMode r6 = new EduIntentMode("UNDETECTED", 0, 0, 0, r13);
        UNDETECTED = r6;
        EduIntentMode r0 = new EduIntentMode("COMMON", 1, 1, 2131900561, r13);
        COMMON = r0;
        EduIntentMode r1 = new EduIntentMode("SINGLE_QUESTION", 2, 2, 2131900562, c.C0123c.a);
        SINGLE_QUESTION = r1;
        EduIntentMode r2 = new EduIntentMode("MULTI_QUESTION", 3, 3, 2131900559, c.b.a);
        MULTI_QUESTION = r2;
        EduIntentMode r3 = new EduIntentMode("HOMEWORK_CORRECTION", 4, 4, 2131899419, r13);
        HOMEWORK_CORRECTION = r3;
        EduIntentMode[] r4 = {r6, r0, r1, r2, r3};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
        Companion = new a();
    }

    public static EduIntentMode[] values() {
        return (EduIntentMode[]) a.clone();
    }

    public final c getClipViewMode() {
        return this.clipViewMode;
    }

    public final int getId() {
        return this.id;
    }

    public final int getTextResId() {
        return this.textResId;
    }

    public static EduIntentMode valueOf(String r1) {
        return (EduIntentMode) r27.a.a(EduIntentMode.class, r1);
    }

    public EduIntentMode(String r1, int r2, int r3, int r4, c r5) {
        super(r1, r2);
        this.id = r3;
        this.textResId = r4;
        this.clipViewMode = r5;
    }
}
