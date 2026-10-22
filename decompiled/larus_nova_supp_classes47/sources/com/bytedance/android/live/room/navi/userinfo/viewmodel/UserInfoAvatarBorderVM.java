package com.bytedance.android.live.room.navi.userinfo.viewmodel;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import k91.a;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR,\u0010\u000e\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007j\b\u0012\u0004\u0012\u00020\u0003`\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoAvatarBorderVM;", "Lcom/bytedance/live/datacontext/DataContext;", "Lk91/a;", "Lpy/k;", "image", "", "updateBorder", "Lcom/bytedance/live/datacontext/n;", "_borderImage$delegate", "Lcom/bytedance/live/datacontext/p;", "get_borderImage", "()Lcom/bytedance/live/datacontext/n;", "_borderImage", "Lcom/bytedance/android/live/core/utils/IReadonlyNullable;", "borderImage", "Lcom/bytedance/live/datacontext/n;", "getBorderImage", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoAvatarBorderVM extends DataContext implements a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p _borderImage$delegate;
    private final n<? extends k> borderImage;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(UserInfoAvatarBorderVM.class, "_borderImage", "get_borderImage()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
    }

    private final n<k> get_borderImage() {
        return (n) this._borderImage$delegate.a(this, $$delegatedProperties[0]);
    }

    public UserInfoAvatarBorderVM() {
        this._borderImage$delegate = q.c(this);
        this.borderImage = get_borderImage();
    }

    public n<? extends k> getBorderImage() {
        return this.borderImage;
    }

    public void updateBorder(k r2) {
        get_borderImage().setValue(r2);
    }
}
