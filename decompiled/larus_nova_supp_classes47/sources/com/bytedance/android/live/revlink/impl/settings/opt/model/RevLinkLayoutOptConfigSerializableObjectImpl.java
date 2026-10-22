package com.bytedance.android.live.revlink.impl.settings.opt.model;

import a51.d;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/opt/model/RevLinkLayoutOptConfigSerializableObjectImpl;", "La51/d;", "", "pkLayoutLazyLoad", "Z", "getPkLayoutLazyLoad", "()Z", "pkLayoutPreInflate", "S7", "multiAnchorWindowSimplify", "G3", "multiAnchorPreInflate", "e9", "pkLayoutPreInflateAnchor", "x0", "multiAnchorPreInflateAnchor", "y4", "", "pkGuestLazyLoadTime", "J", "getPkGuestLazyLoadTime", "()J", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkLayoutOptConfigSerializableObjectImpl implements d {

    @SerializedName("multi_anchor_pre_inflate")
    private final boolean multiAnchorPreInflate;

    @SerializedName("multi_anchor_pre_inflate_anchor")
    private final boolean multiAnchorPreInflateAnchor;

    @SerializedName("multi_anchor_window_simplify")
    private final boolean multiAnchorWindowSimplify;

    @SerializedName("pk_guest_lazy_load_time")
    private final long pkGuestLazyLoadTime;

    @SerializedName("pk_layout_lazy_load")
    private final boolean pkLayoutLazyLoad;

    @SerializedName("pk_layout_pre_inflate")
    private final boolean pkLayoutPreInflate;

    @SerializedName("pk_layout_pre_inflate_anchor")
    private final boolean pkLayoutPreInflateAnchor;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/opt/model/RevLinkLayoutOptConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevLinkLayoutOptConfigSerializableObjectImpl.class);
        }
    }

    public RevLinkLayoutOptConfigSerializableObjectImpl() {
        this.pkLayoutLazyLoad = false;
        this.pkLayoutPreInflate = false;
        this.multiAnchorWindowSimplify = false;
        this.multiAnchorPreInflate = false;
        this.pkLayoutPreInflateAnchor = false;
        this.multiAnchorPreInflateAnchor = false;
        this.pkGuestLazyLoadTime = 1500;
    }

    @Override // a51.d
    public final boolean G3() {
        return this.multiAnchorWindowSimplify;
    }

    @Override // a51.d
    public final boolean S7() {
        return this.pkLayoutPreInflate;
    }

    @Override // a51.d
    public final boolean e9() {
        return this.multiAnchorPreInflate;
    }

    @Override // a51.d
    public final boolean x0() {
        return this.pkLayoutPreInflateAnchor;
    }

    @Override // a51.d
    public final boolean y4() {
        return this.multiAnchorPreInflateAnchor;
    }
}
