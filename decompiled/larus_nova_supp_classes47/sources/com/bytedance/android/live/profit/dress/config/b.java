package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\"\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/b;", "Lvh7/c;", "", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAvatarBorder", "()Lpy/k;", "getAvatarBorder$annotations", "()V", "avatarBorder", "getThumbAvatarBorder", "getThumbAvatarBorder$annotations", "thumbAvatarBorder", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends vh7.c<b> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "avatar_border")
    py.k getAvatarBorder();

    @FieldName(name = "thumb_avatar_border")
    py.k getThumbAvatarBorder();
}
