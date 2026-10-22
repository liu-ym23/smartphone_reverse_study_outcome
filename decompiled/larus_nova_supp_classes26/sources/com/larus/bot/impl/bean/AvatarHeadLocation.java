package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0003HÆ\u0003J%\u0010\n\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R(\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/bot/impl/bean/AvatarHeadLocation;", "Ljava/io/Serializable;", "avatars", "", "Lcom/larus/bot/impl/bean/HeadLocation;", "<init>", "(Ljava/util/List;)V", "getAvatars", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarHeadLocation implements Serializable {

    @SerializedName("avatars")
    private final List<List<HeadLocation>> avatars;

    public AvatarHeadLocation() {
        List r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AvatarHeadLocation copy$default(AvatarHeadLocation r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.avatars;
    L6:
        return r0.copy(r1);
    }

    public final List<List<HeadLocation>> component1() {
        return this.avatars;
    }

    public final AvatarHeadLocation copy(List<? extends List<HeadLocation>> r2) {
        return new AvatarHeadLocation(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof AvatarHeadLocation) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.avatars, ((AvatarHeadLocation) r4).avatars) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<List<HeadLocation>> r0 = this.avatars;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "AvatarHeadLocation(avatars=" + this.avatars + ')';
    }

    public final List<List<HeadLocation>> getAvatars() {
        return this.avatars;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AvatarHeadLocation(List<? extends List<HeadLocation>> r1) {
        this.avatars = r1;
    }

    public /* synthetic */ AvatarHeadLocation(List r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
