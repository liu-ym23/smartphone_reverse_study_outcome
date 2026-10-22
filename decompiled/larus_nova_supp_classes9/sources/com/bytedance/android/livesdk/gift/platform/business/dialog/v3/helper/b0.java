package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(GiftPanelInitStateOptConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/b0;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b0 extends vh7.j<b0> {

    @JsonAdapter(GiftPanelInitStateOptConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "disable_dialog_resume")
    boolean E0();

    @FieldName(name = "select_type_change_opt")
    boolean P2();

    @FieldName(name = "state_transition_opt")
    boolean l8();

    @FieldName(name = "change_receiver_mode_opt")
    boolean o5();

    @FieldName(name = "disable_query_user_honor")
    boolean r0();
}
