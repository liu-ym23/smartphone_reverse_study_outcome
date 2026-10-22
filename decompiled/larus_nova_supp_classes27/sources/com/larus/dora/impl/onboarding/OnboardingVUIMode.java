package com.larus.dora.impl.onboarding;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/onboarding/OnboardingVUIMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "START_ONBOARDING", "START_KEY_ONLY", "START_VOICE_ONLY", "START_RADIO_ONLY", "STOP_ONBOARDING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OnboardingVUIMode extends Enum<OnboardingVUIMode> {
    public static final OnboardingVUIMode START_KEY_ONLY = null;
    public static final OnboardingVUIMode START_ONBOARDING = null;
    public static final OnboardingVUIMode START_RADIO_ONLY = null;
    public static final OnboardingVUIMode START_VOICE_ONLY = null;
    public static final OnboardingVUIMode STOP_ONBOARDING = null;
    public static final /* synthetic */ OnboardingVUIMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<OnboardingVUIMode> getEntries() {
        return b;
    }

    static {
        OnboardingVUIMode r0 = new OnboardingVUIMode("START_ONBOARDING", 0, 4);
        START_ONBOARDING = r0;
        OnboardingVUIMode r1 = new OnboardingVUIMode("START_KEY_ONLY", 1, 5);
        START_KEY_ONLY = r1;
        OnboardingVUIMode r4 = new OnboardingVUIMode("START_VOICE_ONLY", 2, 6);
        START_VOICE_ONLY = r4;
        OnboardingVUIMode r7 = new OnboardingVUIMode("START_RADIO_ONLY", 3, 7);
        START_RADIO_ONLY = r7;
        OnboardingVUIMode r8 = new OnboardingVUIMode("STOP_ONBOARDING", 4, 5);
        STOP_ONBOARDING = r8;
        OnboardingVUIMode[] r6 = {r0, r1, r4, r7, r8};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static OnboardingVUIMode[] values() {
        return (OnboardingVUIMode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static OnboardingVUIMode valueOf(String r1) {
        return (OnboardingVUIMode) r27.a.a(OnboardingVUIMode.class, r1);
    }

    public OnboardingVUIMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
