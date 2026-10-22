package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.condition.UserGroupCondition;
import com.ss.android.lark.search.dto.UserGroupScene;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/picker/config/UserGroup;", "Lcom/ss/android/lark/picker/config/Entity;", "Lcom/ss/android/lark/picker/config/condition/UserGroupCondition;", "Lcom/ss/android/lark/picker/config/UserGroupFilter;", "Lcom/ss/android/lark/picker/config/UserGroupExtra;", "scene", "Lcom/ss/android/lark/search/dto/UserGroupScene;", "<init>", "(Lcom/ss/android/lark/search/dto/UserGroupScene;)V", "filter", "getFilter", "()Lcom/ss/android/lark/picker/config/UserGroupFilter;", "extra", "getExtra", "()Lcom/ss/android/lark/picker/config/UserGroupExtra;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class UserGroup implements Entity<UserGroupCondition<?>, UserGroupFilter, UserGroupExtra> {
    private final UserGroupExtra extra;
    private final UserGroupFilter filter;

    @Override // com.ss.android.lark.picker.config.Entity
    public /* bridge */ /* synthetic */ Extra getExtra() {
        return getExtra();
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public /* bridge */ /* synthetic */ Filter getFilter() {
        return getFilter();
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public UserGroupExtra getExtra() {
        return this.extra;
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public UserGroupFilter getFilter() {
        return this.filter;
    }

    public UserGroup(UserGroupScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.filter = new UserGroupFilter();
        this.extra = new UserGroupExtra(r2);
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public void extra(Function1<? super UserGroupExtra, Unit> r1) {
        Entity.DefaultImpls.extra(this, r1);
    }

    @Override // com.ss.android.lark.picker.config.Entity
    public void filter(Function1<? super UserGroupFilter, Unit> r1) {
        Entity.DefaultImpls.filter(this, r1);
    }
}
