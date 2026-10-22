package com.bytedance.android.live.room.navi.userinfo.viewmodel;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import k91.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR,\u0010\u000b\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\bR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\bR,\u0010\u0011\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\bR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\bR,\u0010\u0017\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u00130\u0003j\b\u0012\u0004\u0012\u00020\u0013`\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoNicknameVM;", "Lcom/bytedance/live/datacontext/DataContext;", "Lk91/c;", "Lcom/bytedance/live/datacontext/n;", "", "_nicknameMaxWidth$delegate", "Lcom/bytedance/live/datacontext/p;", "get_nicknameMaxWidth", "()Lcom/bytedance/live/datacontext/n;", "_nicknameMaxWidth", "Lcom/bytedance/android/live/core/utils/IReadonlyNullable;", "nicknameMaxWidth", "Lcom/bytedance/live/datacontext/n;", "getNicknameMaxWidth", "_nicknameViewVisibility$delegate", "get_nicknameViewVisibility", "_nicknameViewVisibility", "nicknameViewVisibility", "getNicknameViewVisibility", "", "_nicknameMatchTabHeight$delegate", "get_nicknameMatchTabHeight", "_nicknameMatchTabHeight", "nicknameMatchTabHeight", "getNicknameMatchTabHeight", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoNicknameVM extends DataContext implements c {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p _nicknameMatchTabHeight$delegate;
    private final p _nicknameMaxWidth$delegate;
    private final p _nicknameViewVisibility$delegate;
    private final n<? extends Unit> nicknameMatchTabHeight;
    private final n<? extends Integer> nicknameMaxWidth;
    private final n<? extends Integer> nicknameViewVisibility;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(UserInfoNicknameVM.class, "_nicknameMaxWidth", "get_nicknameMaxWidth()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(UserInfoNicknameVM.class, "_nicknameViewVisibility", "get_nicknameViewVisibility()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(UserInfoNicknameVM.class, "_nicknameMatchTabHeight", "get_nicknameMatchTabHeight()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
    }

    private final n<Unit> get_nicknameMatchTabHeight() {
        return (n) this._nicknameMatchTabHeight$delegate.a(this, $$delegatedProperties[2]);
    }

    private final n<Integer> get_nicknameMaxWidth() {
        return (n) this._nicknameMaxWidth$delegate.a(this, $$delegatedProperties[0]);
    }

    private final n<Integer> get_nicknameViewVisibility() {
        return (n) this._nicknameViewVisibility$delegate.a(this, $$delegatedProperties[1]);
    }

    public UserInfoNicknameVM() {
        Intrinsics.checkNotNullParameter(this, "$this$directMutable");
        UserInfoContextExtKt$directMutable$1 r1 = UserInfoContextExtKt$directMutable$1.INSTANCE;
        this._nicknameMaxWidth$delegate = q.b(this, r1);
        this.nicknameMaxWidth = get_nicknameMaxWidth();
        Intrinsics.checkNotNullParameter(this, "$this$directMutable");
        this._nicknameViewVisibility$delegate = q.b(this, r1);
        this.nicknameViewVisibility = get_nicknameViewVisibility();
        Intrinsics.checkNotNullParameter(this, "$this$directMutable");
        this._nicknameMatchTabHeight$delegate = q.b(this, r1);
        this.nicknameMatchTabHeight = get_nicknameMatchTabHeight();
    }

    public n<? extends Unit> getNicknameMatchTabHeight() {
        return this.nicknameMatchTabHeight;
    }

    public n<? extends Integer> getNicknameMaxWidth() {
        return this.nicknameMaxWidth;
    }

    public n<? extends Integer> getNicknameViewVisibility() {
        return this.nicknameViewVisibility;
    }
}
