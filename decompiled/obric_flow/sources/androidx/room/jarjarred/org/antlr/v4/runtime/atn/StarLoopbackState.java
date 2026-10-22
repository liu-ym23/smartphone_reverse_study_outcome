package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

/* JADX INFO: loaded from: classes.dex */
public final class StarLoopbackState extends ATNState {
    public StarLoopbackState() {
    }

    public final StarLoopEntryState getLoopEntryState() {
        return (StarLoopEntryState) transition(0).target;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState
    public int getStateType() {
        return 9;
    }
}
