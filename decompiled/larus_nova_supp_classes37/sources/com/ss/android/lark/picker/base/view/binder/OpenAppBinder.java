package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.ui.tag.f;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.BaseField;
import com.ss.android.lark.search.dto.OpenAppState;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchOpenAppInfo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sz7.v;
import v3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/OpenAppBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchOpenAppInfo;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "bindTag", "", "position", "", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "data", "hasOpenAppAbility", "", "getTagRes", "state", "Lcom/ss/android/lark/search/dto/OpenAppState;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class OpenAppBinder extends CommonBinder<SearchOpenAppInfo> {
    private final Context mContext;
    private final g mOnItemClickHandler;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[OpenAppState.values().length];
            r0[OpenAppState.TENANT_FORBIDDEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[OpenAppState.PLATFORM_FORBIDDEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[OpenAppState.DEVELOPER_FORBIDDEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[OpenAppState.USER_INVISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[OpenAppState.APP_NEED_PAY_USE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[OpenAppState.OFFLINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[OpenAppState.APP_DELETED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private final int getTagRes(OpenAppState r2) {
        switch(WhenMappings.$EnumSwitchMapping$0[r2.ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L8;
        };
    L5:
        return 2131892569;
    L6:
        return 2131892572;
    L8:
        return 2131890276;
    }

    private final boolean hasOpenAppAbility(SearchOpenAppInfo r4) {
        Iterator r5 = r4.getAbilities().iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        SearchOpenAppInfo.SearchOpenAppAbility r0 = (SearchOpenAppInfo.SearchOpenAppAbility) r5.next();
        if (r0.getType() == 2) goto L11;
        if (r0.getType() == 3) goto L20;
        if (r0.getType() != 4) goto L4;
        return true;
    L20:
        return true;
    L11:
        return true;
    L13:
        return false;
    }

    public OpenAppBinder(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "mContext");
        Intrinsics.checkNotNullParameter(r9, "mOnItemClickHandler");
        super(r8, r9, null, 4, null);
        this.mContext = r8;
        this.mOnItemClickHandler = r9;
    }

    public void bindTag(int r4, ChatterChatViewHolder r5, SearchOpenAppInfo r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "data");
        LarkNameTag.a r7 = new LarkNameTag.a(this.mContext);
        if (r6.getAppState() == OpenAppState.USABLE) goto L5;
        int r0 = f.g;
        f.a r1 = new f.a();
        r1.b = 0;
        r1.c = getTagRes(r6.getAppState());
        r1.e = 2131103449;
        r1.g = 2131103456;
        r7.d(new f(r1), true);
    L15:
        r5.getAvatarItemView().getItem().setTag(r7);
        return;
    L5:
        if (r6.isAvailable() == true) goto L7;
        f r2 = ((LarkNameTag.c) r7).b.s;
        boolean r3 = v.a;
        r7.e(r2, !v.a.a());
        if (TextUtils.isEmpty(r6.getAppStoreUrl()) == true) goto L13;
        int r8 = f.g;
        f.a r9 = new f.a();
        r9.b = BaseField.FIELD_TYPE_S_PHONE_NUMBER;
        r9.c = 2131892571;
        r9.e = 2131109133;
        r9.g = 2131109099;
        r7.d(new f(r9), true);
    L13:
        Unit r10 = Unit.INSTANCE;
        goto L15
    L7:
        if (hasOpenAppAbility(r6) == false) goto L9;
        f r11 = ((LarkNameTag.c) r7).b.s;
        boolean r12 = v.a;
        r7.e(r11, !v.a.a());
        goto L15
    L9:
        r7.e(((LarkNameTag.c) r7).b.a, true);
        goto L15
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindTag(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindTag(r1, r2, (SearchOpenAppInfo) r3);
    }
}
