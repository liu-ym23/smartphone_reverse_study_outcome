package com.obric.memorydata.recommend.ui.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/DelayedLoadingStateMachine;", "", "<init>", "()V", "requestPending", "", "loadingVisible", "startRequest", "", "onDelayElapsed", "Lcom/obric/memorydata/recommend/ui/rule/DelayedLoadingStateMachine$Transition;", "finishRequest", "shouldRestoreEditor", "reset", "Transition", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DelayedLoadingStateMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12731b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/DelayedLoadingStateMachine$Transition;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SHOW_LOADING", "HIDE_LOADING", "RESTORE_EDITOR", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Transition extends Enum<Transition> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Transition[] $VALUES = null;
        public static final Transition HIDE_LOADING = null;
        public static final Transition NONE = null;
        public static final Transition RESTORE_EDITOR = null;
        public static final Transition SHOW_LOADING = null;

        private static final /* synthetic */ Transition[] $values() {
            return new Transition[]{NONE, SHOW_LOADING, HIDE_LOADING, RESTORE_EDITOR};
        }

        static {
            NONE = new Transition("NONE", 0);
            SHOW_LOADING = new Transition("SHOW_LOADING", 1);
            HIDE_LOADING = new Transition("HIDE_LOADING", 2);
            RESTORE_EDITOR = new Transition("RESTORE_EDITOR", 3);
            Transition[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Transition(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Transition> getEntries() {
            return $ENTRIES;
        }

        public static Transition valueOf(String r2) {
            return (Transition) ZeusTransformUtils.preCheckCast(Enum.valueOf(Transition.class, r2), Transition.class, "com.obric.memorydata.plugin");
        }

        public static Transition[] values() {
            return (Transition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Transition[].class, "com.obric.memorydata.plugin");
        }
    }

    public DelayedLoadingStateMachine() {
    }

    public final Transition a(boolean r3) {
        this.f12730a = false;
        if (this.f12731b == false) goto L5;
        this.f12731b = false;
        if (r3 == false) goto L10;
        return Transition.RESTORE_EDITOR;
    L10:
        return Transition.HIDE_LOADING;
    L5:
        return Transition.NONE;
    }

    public final void a() {
        this.f12730a = true;
        this.f12731b = false;
    }

    public final Transition b() {
        if (this.f12730a == false) goto L10;
        if (this.f12731b == true) goto L10;
        this.f12731b = true;
        return Transition.SHOW_LOADING;
    L10:
        return Transition.NONE;
    }

    public final void c() {
        this.f12730a = false;
        this.f12731b = false;
    }
}
