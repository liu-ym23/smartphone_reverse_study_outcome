package com.larksuite.component.card.protocol.data.person;

import com.google.gson.JsonObject;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/larksuite/component/card/protocol/data/person/Character;", "Ljava/io/Serializable;", "type", "", "id", "", "content", "avatarKey", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/String;", "getContent", "getAvatarKey", "toJson", "Lcom/google/gson/JsonObject;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Character implements Serializable {
    public static final a Companion = null;
    public static final String TAG = "Character";
    private final String avatarKey;
    private final String content;
    private final String id;
    private final Integer type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public Character() {
        this(null, null, null, null, 15, null);
    }

    public final JsonObject toJson() {
        JsonObject r0 = new JsonObject();
        r0.addProperty("content", this.content);     // Catch: JSONException -> L5
        r0.addProperty("id", this.id);     // Catch: JSONException -> L5
        r0.addProperty("type", this.type);     // Catch: JSONException -> L5
        r0.addProperty("avatarKey", this.avatarKey);     // Catch: JSONException -> L5
    L6:
        return r0;
    L5:
        Log.e(TAG, "person toJSON error");
        goto L6
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getType() {
        return this.type;
    }

    public Character(Integer r1, String r2, String r3, String r4) {
        this.type = r1;
        this.id = r2;
        this.content = r3;
        this.avatarKey = r4;
    }

    public /* synthetic */ Character(Integer r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
