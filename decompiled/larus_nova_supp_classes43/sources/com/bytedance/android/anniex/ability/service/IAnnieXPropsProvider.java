package com.bytedance.android.anniex.ability.service;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.base.service.e;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.Map;
import kotlin.Metadata;
import q26.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/IAnnieXPropsProvider;", "Lq26/c;", "Lcom/bytedance/android/anniex/base/service/e;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IAnnieXPropsProvider extends c, e {
    void C(String r1, KitType r10);

    Map<String, Object> p(String r1, KitType r10);

    void q(String r1, KitType r10, Uri r11);

    void t0(String r1, KitType r10, Context r11);
}
