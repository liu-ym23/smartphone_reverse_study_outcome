package com.bytedance.android.live.broadcast.api.model.component;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.LiveTopicComponent")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\tR\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/component/LiveTopicComponent;", "", "", "isValidTopic", "Lcom/bytedance/android/live/broadcast/api/model/component/BaseComponentModel;", "base", "Lcom/bytedance/android/live/broadcast/api/model/component/BaseComponentModel;", "", "id", "Ljava/lang/String;", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "prefix", "shortPrefix", "topicContent", "shortTopicContent", "defaultContent", "schema", "", "", "showInSubTabs", "Ljava/util/List;", "", "topicFrom", "Ljava/lang/Long;", "topicType", "<init>", "()V", "Companion", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveTopicComponent implements h {
    public static final a Companion = null;
    public static final long TOPIC_FROM_RECOMMEND = 1;
    public static final long TOPIC_FROM_SCHEMA = 2;

    @SerializedName("base")
    public BaseComponentModel base;

    @SerializedName("default_content")
    public String defaultContent;

    @SerializedName("icon")
    public ImageModel icon;

    @SerializedName("id")
    public String id;

    @SerializedName("prefix")
    public String prefix;

    @SerializedName("schema")
    public String schema;

    @SerializedName("short_prefix")
    public String shortPrefix;

    @SerializedName("short_topic_content")
    public String shortTopicContent;

    @SerializedName("show_in_sub_tabs")
    public List<Integer> showInSubTabs;

    @SerializedName("topic_content")
    public String topicContent;

    @SerializedName("topic_from")
    public Long topicFrom;

    @SerializedName("topic_type")
    public Long topicType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LiveTopicComponent() {
    }

    public final boolean isValidTopic() {
        String r0 = this.id;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return false;
    L12:
        if (r2.a(this.shortTopicContent) == false) goto L14;
        return true;
    L14:
        if (r2.a(this.topicContent) == true) goto L19;
        return false;
    L19:
        return true;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public LiveTopicComponent(g r5) {
        this.showInSubTabs = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L19;
        switch(r2) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L7:
        this.topicType = Long.valueOf(r5.j());
        goto L3
    L8:
        this.topicFrom = Long.valueOf(r5.j());
        goto L3
    L9:
        this.showInSubTabs.add(Integer.valueOf(r5.i()));
        goto L3
    L10:
        this.schema = am3.h.c(r5);
        goto L3
    L11:
        this.defaultContent = am3.h.c(r5);
        goto L3
    L12:
        this.topicContent = am3.h.c(r5);
        goto L3
    L13:
        this.shortTopicContent = am3.h.c(r5);
        goto L3
    L14:
        this.shortPrefix = am3.h.c(r5);
        goto L3
    L15:
        this.prefix = am3.h.c(r5);
        goto L3
    L16:
        this.icon = x.a(r5);
        goto L3
    L17:
        this.id = am3.h.c(r5);
        goto L3
    L18:
        this.base = new BaseComponentModel(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L19:
        r5.d(r0);
    }
}
