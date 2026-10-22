package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface l extends vh7.c<l> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "thanks_carousel_duration")
    long getInteractCarouselDuration();

    @FieldName(name = "thanks_content")
    CharSequence getInteractContent();

    @FieldName(name = "interact_type")
    int getInteractType();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "send_gift_user")
    IBaseUser getSendGiftUser();

    @FieldName(name = "text")
    Text getText();

    String getToUsedID();
}
