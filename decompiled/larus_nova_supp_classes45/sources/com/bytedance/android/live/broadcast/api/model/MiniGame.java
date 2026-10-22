package com.bytedance.android.live.broadcast.api.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/MiniGame;", "Ljava/io/Serializable;", "gameId", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "getName", "setName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniGame implements Serializable {

    @SerializedName("game_id")
    private String gameId;

    @SerializedName("name")
    private String name;

    public MiniGame() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ MiniGame copy$default(MiniGame r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.gameId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.name;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.gameId;
    }

    public final String component2() {
        return this.name;
    }

    public final MiniGame copy(String r2, String r3) {
        return new MiniGame(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof MiniGame) == false) goto L10;
        MiniGame r4 = (MiniGame) r3;
        if (Intrinsics.areEqual(this.gameId, r4.gameId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.gameId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "MiniGame(gameId=" + this.gameId + ", name=" + this.name + ")";
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getName() {
        return this.name;
    }

    public final void setGameId(String r1) {
        this.gameId = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public MiniGame(String r1, String r2) {
        this.gameId = r1;
        this.name = r2;
    }

    public /* synthetic */ MiniGame(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
