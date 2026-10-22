package com.bytedance.android.live.revlink.impl.config;

import com.bytedance.live.kmp.util.c;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r11.m;
import w11.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LiveRandomPkTitleConfigSerializableObjectImpl;", "Lr11/m;", "", "mWaitingTile", "Ljava/lang/String;", "getMWaitingTile", "()Ljava/lang/String;", "mWaitingSubTile", "getMWaitingSubTile", "mWaitedTitle", "getMWaitedTitle", "mWaitedSubTitle", "getMWaitedSubTitle", "mPopTitlePlus", "getMPopTitlePlus", "mPkValuePopupMessage", "i8", "mExpandScopePopupMessage", "I7", "mGameMatchPopupMessage", "C8", "mPopTitleLess", "getMPopTitleLess", "mPopTitleZero", "getMPopTitleZero", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveRandomPkTitleConfigSerializableObjectImpl implements m {

    @SerializedName("expand_scope_popup_message")
    private final String mExpandScopePopupMessage;

    @SerializedName("game_match_popup_message")
    private final String mGameMatchPopupMessage;

    @SerializedName("pk_value_popup_message")
    private final String mPkValuePopupMessage;

    @SerializedName("less_30_second_tips")
    private final String mPopTitleLess;

    @SerializedName("plus_30_second_tips")
    private final String mPopTitlePlus;

    @SerializedName("zero_second_tips")
    private final String mPopTitleZero;

    @SerializedName("unexcept_time_subTitle")
    private final String mWaitedSubTitle;

    @SerializedName("unexcept_time_title")
    private final String mWaitedTitle;

    @SerializedName("except_time_subTitle")
    private final String mWaitingSubTile;

    @SerializedName("except_time_title")
    private final String mWaitingTile;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LiveRandomPkTitleConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LiveRandomPkTitleConfigSerializableObjectImpl.class);
        }
    }

    public LiveRandomPkTitleConfigSerializableObjectImpl() {
        c r0 = c.a;
        int r1 = a.a;
        this.mWaitingTile = c.a(2131921522, new Object[0]);
        this.mWaitingSubTile = c.a(2131921520, new Object[0]);
        this.mWaitedTitle = c.a(2131921521, new Object[0]);
        this.mWaitedSubTitle = c.a(2131921519, new Object[0]);
        this.mPopTitlePlus = c.a(2131921504, new Object[0]);
        this.mPkValuePopupMessage = c.a(2131921507, new Object[0]);
        this.mExpandScopePopupMessage = c.a(2131921508, new Object[0]);
        this.mGameMatchPopupMessage = c.a(2131921509, new Object[0]);
        this.mPopTitleLess = c.a(2131921505, new Object[0]);
        this.mPopTitleZero = c.a(2131921506, new Object[0]);
    }

    @Override // r11.m
    public final String C8() {
        return this.mGameMatchPopupMessage;
    }

    @Override // r11.m
    public final String I7() {
        return this.mExpandScopePopupMessage;
    }

    @Override // r11.m
    public final String i8() {
        return this.mPkValuePopupMessage;
    }
}
