package com.larus.camera.impl.ui.viewmodel;

import com.larus.bmhome.instruction.monitor.SuggestPromptErrorType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/camera/impl/ui/viewmodel/ChangeState;", "", "state", "", "<init>", "(Ljava/lang/String;II)V", "getState", "()I", SuggestPromptErrorType.ERROR_TYPE_DEFAULT, "SHOW", "HIDE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChangeState extends Enum<ChangeState> {
    public static final ChangeState DEFAULT = null;
    public static final ChangeState HIDE = null;
    public static final ChangeState SHOW = null;
    public static final /* synthetic */ ChangeState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int state;

    public static EnumEntries<ChangeState> getEntries() {
        return b;
    }

    static {
        ChangeState r0 = new ChangeState(SuggestPromptErrorType.ERROR_TYPE_DEFAULT, 0, 0);
        DEFAULT = r0;
        ChangeState r1 = new ChangeState("SHOW", 1, 1);
        SHOW = r1;
        ChangeState r3 = new ChangeState("HIDE", 2, 2);
        HIDE = r3;
        ChangeState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ChangeState[] values() {
        return (ChangeState[]) a.clone();
    }

    public final int getState() {
        return this.state;
    }

    public static ChangeState valueOf(String r1) {
        return (ChangeState) r27.a.a(ChangeState.class, r1);
    }

    public ChangeState(String r1, int r2, int r3) {
        super(r1, r2);
        this.state = r3;
    }
}
