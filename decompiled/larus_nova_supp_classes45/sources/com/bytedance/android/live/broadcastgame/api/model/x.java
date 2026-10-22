package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.InteractWidget")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\tR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0006R\u0016\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0016\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/x;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/f2$b;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/o2$b;", "Lcom/bytedance/android/live/broadcastgame/api/model/l;", "", "interactId", "I", "", "name", "Ljava/lang/String;", "desc", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "jumpSchema", "", "Lcom/bytedance/android/live/broadcastgame/api/model/y;", "label", "Ljava/util/List;", "status", "extra", "gameCardExtra", "a", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x implements f2.b, o2.b, l, vh7.h {
    public boolean a;
    public r b;
    public final n c;

    @SerializedName("desc")
    public String desc;

    @SerializedName("extra")
    public String extra;

    @SerializedName("game_extra")
    public String gameCardExtra;

    @SerializedName("icon")
    public ImageModel icon;

    @SerializedName("interact_id")
    public int interactId;

    @SerializedName("jump_schema")
    public String jumpSchema;

    @SerializedName("label")
    public List<y> label;

    @SerializedName("name")
    public String name;

    @SerializedName("status")
    public int status;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "InteractWidget(interactId=" + this.interactId + ", name=" + this.name + ", desc=" + this.desc + ", icon=" + this.icon + ", jumpSchema=" + this.jumpSchema + ", label=" + this.label + ", status=" + this.status + ", extra=" + this.extra + ", gameCardExtra=" + this.gameCardExtra + ")";
    }

    public final String c() {
        if (this.c.c == true) goto L6;
        return String.valueOf(this.interactId);
    L6:
        return f();
    }

    public final r e() {
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
        this.b = r4;     // Catch: Exception -> L21
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
        return this.b;
    }

    public final String f() {
        int r0 = w.a;
        return w.a.a(this.interactId, this.name, e(), this.extra);
    }

    public final int hashCode() {
        int r0 = this.name.hashCode() * 31;
        ImageModel r1 = this.icon;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((r0 + r2) * 31) + this.extra.hashCode();
    L5:
        r2 = 0;
        goto L7
    }

    public x() {
        this.c = new n(0);
        this.interactId = 0;
        this.name = "";
        this.desc = "";
        this.icon = null;
        this.jumpSchema = "";
        this.label = new ArrayList();
        this.status = 0;
        this.extra = "";
        this.gameCardExtra = "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final List<Long> a() {
        r r0 = e();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.supportiveEntrance;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final r d() {
        return e();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.model.l
    public final int b() {
        return this.interactId;
    }

    public x(am3.g r7) {
        this.label = new ArrayList();
        this.c = new n(0);
        long r2 = r7.c();
        int r0 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L22;
        if (r4 != 21) goto L8;
        this.status = r7.i();
        r0 = r0 | 2;
        goto L3
    L8:
        if (r4 != 100) goto L10;
        this.extra = am3.h.c(r7);
        goto L3
    L10:
        if (r4 != 101) goto L11;
        this.gameCardExtra = am3.h.c(r7);
        goto L3
    L11:
        switch(r4) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L12;
        };
    L13:
        this.label.add(new y(r7));
        goto L3
    L14:
        this.jumpSchema = am3.h.c(r7);
        goto L3
    L15:
        this.icon = com.bytedance.android.live.base.model.x.a(r7);
        goto L3
    L16:
        this.desc = am3.h.c(r7);
        goto L3
    L17:
        this.name = am3.h.c(r7);
        goto L3
    L18:
        this.interactId = (int) r7.j();
        r0 = r0 | 1;
        goto L3
    L12:
        am3.h.e(r7);
        goto L3
    L22:
        r7.d(r2);
        if ((r0 & 1) != 0) goto L26;
        this.interactId = 0;
    L26:
        if (this.name != null) goto L29;
        this.name = "";
    L29:
        if (this.desc != null) goto L32;
        this.desc = "";
    L32:
        if (this.icon != null) goto L35;
        this.icon = null;
    L35:
        if (this.jumpSchema != null) goto L38;
        this.jumpSchema = "";
    L38:
        if (this.label.isEmpty() == false) goto L41;
        this.label = new ArrayList();
    L41:
        if ((r0 & 2) != 0) goto L44;
        this.status = 0;
    L44:
        if (this.extra != null) goto L47;
        this.extra = "";
    L47:
        if (this.gameCardExtra != null) goto L75;
        this.gameCardExtra = "";
        return;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L5;
        return true;
    L5:
        String r2 = null;
        if (r6 == null) goto L8;
        Class<?> r3 = r6.getClass();
    L10:
        if ((!Intrinsics.areEqual(x.class, r3)) == false) goto L13;
        return false;
    L13:
        if ((r6 instanceof InteractEntranceCell) == true) goto L15;
        return false;
    L15:
        InteractEntranceCell r7 = (InteractEntranceCell) r6;
        if ((!Intrinsics.areEqual(this.name, r7.title)) == false) goto L18;
        return false;
    L18:
        ImageModel r1 = this.icon;
        if (r1 == null) goto L21;
        String r4 = r1.mUri;
    L22:
        ImageModel r5 = r7.icon;
        if (r5 == null) goto L26;
        r2 = r5.mUri;
    L26:
        if ((!Intrinsics.areEqual(r4, r2)) == false) goto L29;
        return false;
    L29:
        if ((!Intrinsics.areEqual(f(), r7.h())) == false) goto L31;
        return false;
    L31:
        return true;
    L21:
        r4 = null;
        goto L22
    L8:
        r3 = null;
        goto L10
    }
}
