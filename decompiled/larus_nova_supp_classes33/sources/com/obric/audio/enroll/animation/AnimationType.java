package com.obric.audio.enroll.animation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/audio/enroll/animation/AnimationType;", "", "<init>", "(Ljava/lang/String;I)V", "FADE_IN_TO_CANDIDATE", "FROM_CANDIDATE_TO_STAGE", "FROM_STAGE_TO_DONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AnimationType extends Enum<AnimationType> {
    public static final AnimationType FADE_IN_TO_CANDIDATE = null;
    public static final AnimationType FROM_CANDIDATE_TO_STAGE = null;
    public static final AnimationType FROM_STAGE_TO_DONE = null;
    public static final /* synthetic */ AnimationType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AnimationType> getEntries() {
        return b;
    }

    static {
        AnimationType r0 = new AnimationType("FADE_IN_TO_CANDIDATE", 0);
        FADE_IN_TO_CANDIDATE = r0;
        AnimationType r1 = new AnimationType("FROM_CANDIDATE_TO_STAGE", 1);
        FROM_CANDIDATE_TO_STAGE = r1;
        AnimationType r3 = new AnimationType("FROM_STAGE_TO_DONE", 2);
        FROM_STAGE_TO_DONE = r3;
        AnimationType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AnimationType[] values() {
        return (AnimationType[]) a.clone();
    }

    public static AnimationType valueOf(String r1) {
        return (AnimationType) a.a(AnimationType.class, r1);
    }

    public AnimationType(String r1, int r2) {
        super(r1, r2);
    }
}
