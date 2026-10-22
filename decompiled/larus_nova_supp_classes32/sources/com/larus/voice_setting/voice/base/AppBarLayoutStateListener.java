package com.larus.voice_setting.voice.base;

import com.google.android.material.appbar.AppBarLayout;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class AppBarLayoutStateListener implements AppBarLayout.OnOffsetChangedListener {
    public State a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/voice_setting/voice/base/AppBarLayoutStateListener$State;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", "SCROLLING", "flow-voice-setting-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State COLLAPSED = null;
        public static final State EXPANDED = null;
        public static final State SCROLLING = null;
        public static final /* synthetic */ State[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<State> getEntries() {
            return b;
        }

        static {
            State r0 = new State("EXPANDED", 0);
            EXPANDED = r0;
            State r1 = new State("COLLAPSED", 1);
            COLLAPSED = r1;
            State r3 = new State("SCROLLING", 2);
            SCROLLING = r3;
            State[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public abstract void a(AppBarLayout r1, State r2, State r3);

    public AppBarLayoutStateListener() {
        this.a = State.EXPANDED;
    }

    public final void onOffsetChanged(AppBarLayout r2, int r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != 0) goto L9;
        State r4 = this.a;
        State r0 = State.EXPANDED;
        if (r4 == r0) goto L17;
        a(r2, r4, r0);
        this.a = r0;
        return;
    L17:
        return;
    L9:
        if (Math.abs(r3) < r2.getTotalScrollRange()) goto L13;
        State r5 = this.a;
        State r1 = State.COLLAPSED;
        if (r5 == r1) goto L19;
        a(r2, r5, r1);
        this.a = r1;
        return;
    L19:
        return;
    L13:
        State r6 = this.a;
        State r7 = State.SCROLLING;
        if (r6 == r7) goto L21;
        a(r2, r6, r7);
        this.a = r7;
        return;
    }
}
