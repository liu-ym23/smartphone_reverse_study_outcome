package com.bytedance.android.live.base.model.data.activityemoji;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/base/model/data/activityemoji/b;", "Lvh7/c;", "", "", "getId", "()J", "setId", "(J)V", "getId$annotations", "()V", "id", "", "getIdStr", "()Ljava/lang/String;", "setIdStr", "(Ljava/lang/String;)V", "getIdStr$annotations", "idStr", "getName", "setName", "getName$annotations", "name", "Lpy/k;", "getEmoji", "()Lpy/k;", "setEmoji", "(Lpy/k;)V", "getEmoji$annotations", "emoji", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends c<b> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ e castTo(Class r1);

    /* synthetic */ e castToOrNull(Class r1);

    /* synthetic */ long getActivityEmojiGroupId();

    @FieldName(name = "emoji")
    k getEmoji();

    @FieldName(name = "id")
    long getId();

    @FieldName(name = "id_str")
    String getIdStr();

    @FieldName(name = "name")
    String getName();

    /* synthetic */ void setActivityEmojiGroupId(long r1);

    @FieldName(name = "emoji#setter")
    void setEmoji(k r1);

    @FieldName(name = "id#setter")
    void setId(long r1);

    @FieldName(name = "id_str#setter")
    void setIdStr(String r1);

    @FieldName(name = "name#setter")
    void setName(String r1);
}
