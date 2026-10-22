package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/q1;", "Lvh7/c;", BuildConfig.FLAVOR, "getFetchFrom", "()I", "getFetchFrom$annotations", "()V", "fetchFrom", "getGroupId", "getGroupId$annotations", "groupId", "getImageType", "getImageType$annotations", "imageType", "Lpy/k;", "getImage", "()Lpy/k;", "getImage$annotations", "image", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q1 extends vh7.c<q1> {
    public static final a Companion = null;
    public static final int FETCH_FROM_CACHE = 2;
    public static final int FETCH_FROM_RESPONSE = 1;
    public static final int FETCH_FROM_UNKNOWN = 0;
    public static final int GIFT_IMAGE_TYPE_LABEL_ICON = 3;
    public static final int GIFT_IMAGE_TYPE_PNG_ICON = 1;
    public static final int GIFT_IMAGE_TYPE_UNKNOWN = 0;
    public static final int GIFT_IMAGE_TYPE_WEBP_ICON = 2;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "fetch_from")
    int getFetchFrom();

    @FieldName(name = "group_id")
    int getGroupId();

    @FieldName(name = "image")
    py.k getImage();

    @FieldName(name = "type")
    int getImageType();
}
