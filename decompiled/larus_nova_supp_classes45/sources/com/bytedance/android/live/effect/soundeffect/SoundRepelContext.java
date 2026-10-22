package com.bytedance.android.live.effect.soundeffect;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/effect/soundeffect/SoundRepelContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/live/effect/soundeffect/SoundRepelContext$SoundEffectState;", "soundEffectState$delegate", "Lcom/bytedance/live/datacontext/p;", "getSoundEffectState", "()Lcom/bytedance/live/datacontext/m;", "soundEffectState", "", "ktvState$delegate", "getKtvState", "ktvState", "effectGameState$delegate", "getEffectGameState", "effectGameState", "getSoundEffectUsing", "()Z", "soundEffectUsing", "<init>", "()V", "Companion", "a", "SoundEffectState", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SoundRepelContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "SoundRepelContext";
    private final p effectGameState$delegate;
    private final p ktvState$delegate;
    private final p soundEffectState$delegate;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/soundeffect/SoundRepelContext$SoundEffectState;", "", "ENABLE", "USING", "DISABLE_CAUSE_KTV", "DISABLE_CAUSE_SOUNDSTICKER", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SoundEffectState extends Enum<SoundEffectState> {
        public static final SoundEffectState DISABLE_CAUSE_KTV = null;
        public static final SoundEffectState DISABLE_CAUSE_SOUNDSTICKER = null;
        public static final SoundEffectState ENABLE = null;
        public static final SoundEffectState USING = null;
        public static final /* synthetic */ SoundEffectState[] a = null;

        static {
            SoundEffectState r1 = new SoundEffectState("ENABLE", 0);
            ENABLE = r1;
            SoundEffectState r2 = new SoundEffectState("USING", 1);
            USING = r2;
            SoundEffectState r3 = new SoundEffectState("DISABLE_CAUSE_KTV", 2);
            DISABLE_CAUSE_KTV = r3;
            SoundEffectState r4 = new SoundEffectState("DISABLE_CAUSE_SOUNDSTICKER", 3);
            DISABLE_CAUSE_SOUNDSTICKER = r4;
            a = new SoundEffectState[]{r1, r2, r3, r4};
        }

        public static SoundEffectState valueOf(String r1) {
            return (SoundEffectState) r27.a.a(SoundEffectState.class, r1);
        }

        public static SoundEffectState[] values() {
            return (SoundEffectState[]) a.clone();
        }

        public SoundEffectState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(SoundRepelContext.class, "soundEffectState", "getSoundEffectState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(SoundRepelContext.class, "ktvState", "getKtvState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(SoundRepelContext.class, "effectGameState", "getEffectGameState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final m<Boolean> getEffectGameState() {
        return (m) this.effectGameState$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Boolean> getKtvState() {
        return (m) this.ktvState$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<SoundEffectState> getSoundEffectState() {
        return (m) this.soundEffectState$delegate.a(this, $$delegatedProperties[0]);
    }

    public SoundRepelContext() {
        this.soundEffectState$delegate = q.d(this, SoundEffectState.ENABLE);
        Boolean r0 = Boolean.FALSE;
        this.ktvState$delegate = q.d(this, r0);
        this.effectGameState$delegate = q.d(this, r0);
    }

    public final boolean getSoundEffectUsing() {
        if (((SoundEffectState) getSoundEffectState().getValue()) != SoundEffectState.USING) goto L5;
        return true;
    L5:
        return false;
    }
}
