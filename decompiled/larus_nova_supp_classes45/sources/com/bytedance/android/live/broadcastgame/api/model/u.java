package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.RoomInteractData")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0016\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/u;", "Lcom/bytedance/android/live/broadcastgame/api/model/l;", "", "interactId", "I", "", "name", "Ljava/lang/String;", "", "iconUrl", "Ljava/util/List;", "", "rank", "J", "groupType", "supportiveEntrance", "extra", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u implements l, vh7.h {
    public boolean a;
    public n b;
    public boolean c;
    public String d;
    public boolean e;

    @SerializedName("extra")
    public String extra;
    public String f;
    public int g;

    @SerializedName("group_type")
    public long groupType;
    public com.bytedance.android.live.broadcastgame.api.interactgame.p h;
    public String i;

    @SerializedName("icon_url")
    public List<String> iconUrl;

    @SerializedName("interact_id")
    public int interactId;
    public List<String> j;
    public r k;

    @SerializedName("name")
    public String name;

    @SerializedName("rank")
    public long rank;

    @SerializedName("support_live_entrance_list")
    public List<Long> supportiveEntrance;

    public final String toString() {
        return "InteractItem(interactId=" + this.interactId + ", name=" + this.name + ", iconUrl=" + this.iconUrl + ", rank=" + this.rank + ", groupType=" + this.groupType + ", supportiveEntrance=" + this.supportiveEntrance + ", extra=" + this.extra + ")";
    }

    public final r c() {
        boolean r0 = this.a;
        if (r0 == true) goto L25;
        if (r0 == true) goto L25;
        String r1 = this.extra;
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L26;
    L23:
        this.a = true;
        goto L25
    L26:
        JsonObject r3 = GsonHelper.parser().parse(this.extra).getAsJsonObject();     // Catch: Exception -> L21
        r3.addProperty("game_name", this.name);     // Catch: Exception -> L21
        r3.addProperty("anchor_live_version", Integer.valueOf(com.bytedance.android.livesdk.paas.c.b()));     // Catch: Exception -> L21
        r r4 = (r) GsonHelper.get().fromJson(r3, r.class);     // Catch: Exception -> L21
        this.k = r4;     // Catch: Exception -> L21
        if (r4 != null) goto L17;
    L19:
        r3.toString();     // Catch: Exception -> L21
        goto L23
    L17:
        if (this.interactId != InteractID.EffectGame.getValue()) goto L19;
        r3.addProperty("game_identifier", Long.valueOf(r4.l()));     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
    L25:
        return this.k;
    }

    public final String e() {
        int r0 = w.a;
        return w.a.a(this.interactId, this.name, c(), this.extra);
    }

    public final int hashCode() {
        return (((this.name.hashCode() * 31) + this.iconUrl.hashCode()) * 31) + this.extra.hashCode();
    }

    public u() {
        this.b = new n(0);
        this.d = "";
        this.f = "";
        this.g = -1;
        this.i = "";
        this.j = new ArrayList();
        this.interactId = InteractID.Unknown.getValue();
        this.name = "";
        this.iconUrl = new ArrayList();
        this.rank = 0;
        this.groupType = 0;
        this.supportiveEntrance = new ArrayList();
        this.extra = "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final r d() {
        return c();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final List<Long> a() {
        return this.supportiveEntrance;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final int b() {
        return this.interactId;
    }

    public u(am3.g r9) {
        this.iconUrl = new ArrayList();
        this.supportiveEntrance = new ArrayList();
        int r1 = 0;
        this.b = new n(0);
        this.d = "";
        this.f = "";
        this.g = -1;
        this.i = "";
        this.j = new ArrayList();
        long r3 = r9.c();
    L3:
        int r5 = r9.f();
        if (r5 == (-1)) goto L15;
        switch(r5) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        List r6 = this.supportiveEntrance;
        Object r7 = Long.valueOf(r9.j());
    L12:
        r6.add(r7);
        goto L3
    L8:
        this.extra = am3.h.c(r9);
        goto L3
    L9:
        this.groupType = r9.j();
        r1 = r1 | 4;
        goto L3
    L10:
        this.rank = r9.j();
        r1 = r1 | 2;
        goto L3
    L11:
        r6 = this.iconUrl;
        r7 = am3.h.c(r9);
        goto L12
    L13:
        this.name = am3.h.c(r9);
        goto L3
    L14:
        this.interactId = r9.i();
        r1 = r1 | 1;
        goto L3
    L6:
        am3.h.e(r9);
        goto L3
    L15:
        r9.d(r3);
        if ((r1 & 1) != 0) goto L19;
        this.interactId = InteractID.Unknown.getValue();
    L19:
        if (this.name != null) goto L22;
        this.name = "";
    L22:
        if (this.iconUrl.isEmpty() == false) goto L25;
        this.iconUrl = new ArrayList();
    L25:
        if ((r1 & 2) != 0) goto L28;
        this.rank = 0;
    L28:
        if ((r1 & 4) != 0) goto L31;
        this.groupType = 0;
    L31:
        if (this.supportiveEntrance.isEmpty() == false) goto L34;
        this.supportiveEntrance = new ArrayList();
    L34:
        if (this.extra != null) goto L54;
        this.extra = "";
        return;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(u.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L24;
        u r6 = (u) r5;
        if ((!Intrinsics.areEqual(this.name, r6.name)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.iconUrl, r6.iconUrl)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(e(), r6.e())) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.model.InteractItem");
    L8:
        r2 = null;
        goto L10
    }

    public /* synthetic */ u(int r11, String r12, List r13, String r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r11 = InteractID.Unknown.getValue();
    L5:
        int r1 = r11;
        if ((r15 & 2) == 0) goto L8;
        String r2 = "";
    L10:
        if ((r15 & 4) == 0) goto L12;
        r13 = new ArrayList();
    L12:
        List r3 = r13;
        if ((r15 & 32) == 0) goto L15;
        ArrayList r16 = new ArrayList();
    L16:
        ArrayList r8 = r16;
        if ((r15 & 64) == 0) goto L19;
        String r9 = "";
    L20:
        this(r1, r2, r3, 0, 0, r8, r9);
        return;
    L19:
        r9 = r14;
        goto L20
    L15:
        r16 = null;
        goto L16
    L8:
        r2 = r12;
        goto L10
    }

    public u(int r2, String r3, List<String> r4, long r5, long r7, List<Long> r9, String r11) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "iconUrl");
        Intrinsics.checkNotNullParameter(r11, "extra");
        this.interactId = r2;
        this.name = r3;
        this.iconUrl = r4;
        this.rank = r5;
        this.groupType = r7;
        this.supportiveEntrance = r9;
        this.extra = r11;
        this.b = new n(0);
        this.d = "";
        this.f = "";
        this.g = -1;
        this.i = "";
        this.j = new ArrayList();
    }
}
