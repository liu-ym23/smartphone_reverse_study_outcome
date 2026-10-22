package com.bytedance.android.live.room.navi.userinfo.viewmodel;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import k91.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR,\u0010\u000b\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\bR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\bR,\u0010\u0011\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\bR!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoFlipTabVM;", "Lcom/bytedance/live/datacontext/DataContext;", "Lk91/b;", "Lcom/bytedance/live/datacontext/n;", "", "_initFlipperDataTabType$delegate", "Lcom/bytedance/live/datacontext/p;", "get_initFlipperDataTabType", "()Lcom/bytedance/live/datacontext/n;", "_initFlipperDataTabType", "Lcom/bytedance/android/live/core/utils/IReadonlyNullable;", "initFlipperDataTabType", "Lcom/bytedance/live/datacontext/n;", "getInitFlipperDataTabType", "_reloadTab$delegate", "get_reloadTab", "_reloadTab", "reloadTab", "getReloadTab", "Lcom/bytedance/live/datacontext/k;", "", "_updateFlipLayoutByMarqueeNickname$delegate", "get_updateFlipLayoutByMarqueeNickname", "()Lcom/bytedance/live/datacontext/k;", "_updateFlipLayoutByMarqueeNickname", "changeFlipLayoutWidthByMarqueeNickname", "Lcom/bytedance/live/datacontext/k;", "getChangeFlipLayoutWidthByMarqueeNickname", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoFlipTabVM extends DataContext implements b {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p _initFlipperDataTabType$delegate;
    private final p _reloadTab$delegate;
    private final p _updateFlipLayoutByMarqueeNickname$delegate;
    private final k<Unit> changeFlipLayoutWidthByMarqueeNickname;
    private final n<? extends Integer> initFlipperDataTabType;
    private final n<? extends Integer> reloadTab;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(UserInfoFlipTabVM.class, "_initFlipperDataTabType", "get_initFlipperDataTabType()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(UserInfoFlipTabVM.class, "_reloadTab", "get_reloadTab()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(UserInfoFlipTabVM.class, "_updateFlipLayoutByMarqueeNickname", "get_updateFlipLayoutByMarqueeNickname()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
    }

    private final n<Integer> get_initFlipperDataTabType() {
        return (n) this._initFlipperDataTabType$delegate.a(this, $$delegatedProperties[0]);
    }

    private final n<Integer> get_reloadTab() {
        return (n) this._reloadTab$delegate.a(this, $$delegatedProperties[1]);
    }

    private final k<Unit> get_updateFlipLayoutByMarqueeNickname() {
        return (k) this._updateFlipLayoutByMarqueeNickname$delegate.a(this, $$delegatedProperties[2]);
    }

    public UserInfoFlipTabVM() {
        Intrinsics.checkNotNullParameter(this, "$this$directMutable");
        this._initFlipperDataTabType$delegate = q.b(this, UserInfoContextExtKt$directMutable$1.INSTANCE);
        this.initFlipperDataTabType = get_initFlipperDataTabType();
        this._reloadTab$delegate = q.c(this);
        this.reloadTab = get_reloadTab();
        this._updateFlipLayoutByMarqueeNickname$delegate = e.b(this);
        this.changeFlipLayoutWidthByMarqueeNickname = get_updateFlipLayoutByMarqueeNickname();
    }

    public k<Unit> getChangeFlipLayoutWidthByMarqueeNickname() {
        return this.changeFlipLayoutWidthByMarqueeNickname;
    }

    public n<? extends Integer> getInitFlipperDataTabType() {
        return this.initFlipperDataTabType;
    }

    public n<? extends Integer> getReloadTab() {
        return this.reloadTab;
    }
}
