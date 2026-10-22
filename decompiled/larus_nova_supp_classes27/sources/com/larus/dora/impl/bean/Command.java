package com.larus.dora.impl.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/dora/impl/bean/Command;", "", "commandType", "", "<init>", "(J)V", "getCommandType", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Command {

    @SerializedName("command_type")
    private final long commandType;

    public Command() {
        long r2 = 0;
        this(r2, 1, null);
    }

    public static /* synthetic */ Command copy$default(Command r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.commandType;
    L6:
        return r0.copy(r1);
    }

    public final long component1() {
        return this.commandType;
    }

    public final Command copy(long r2) {
        return new Command(r2);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof Command) == true) goto L9;
        return false;
    L9:
        if (this.commandType == ((Command) r8).commandType) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        long r0 = this.commandType;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public String toString() {
        return "Command(commandType=" + this.commandType + ')';
    }

    public final long getCommandType() {
        return this.commandType;
    }

    public Command(long r1) {
        this.commandType = r1;
    }

    public /* synthetic */ Command(long r1, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1);
    }
}
