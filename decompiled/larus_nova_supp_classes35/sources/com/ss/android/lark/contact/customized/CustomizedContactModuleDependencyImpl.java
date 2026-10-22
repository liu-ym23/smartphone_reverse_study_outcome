package com.ss.android.lark.contact.customized;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.base.dependency.BaseContactThirdBizService;
import com.ss.android.lark.contact.customized.externalinvite.OfficeInviteExternalActivity;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.profile.entity.Profile;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@ClaymoreImpl(com.ss.android.lark.contact.base.dependency.a.class)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J2\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001cH\u0016J \u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0012H\u0016J \u0010&\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0012H\u0016J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0012H\u0016J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006/"}, d2 = {"Lcom/ss/android/lark/contact/customized/CustomizedContactModuleDependencyImpl;", "Lcom/ss/android/lark/contact/base/dependency/IContactBaseModuleDependency;", "<init>", "()V", "iMApi", "Lcom/ss/android/lark/biz/im/api/IIMApi;", "getIMApi", "()Lcom/ss/android/lark/biz/im/api/IIMApi;", "iMApi$delegate", "Lkotlin/Lazy;", "isSimpleTenant", BuildConfig.FLAVOR, "isSmallB", "openChatFromContactHomeByChatId", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "chatId", BuildConfig.FLAVOR, "fromTag", "getChatParser", "Lcom/ss/android/lark/chat/api/IChatParser;", "jumpProfilePage", "chatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "profileObjOrId", BuildConfig.FLAVOR, "source", BuildConfig.FLAVOR, "jumpProfilePageForResult", "curFragment", "Landroidx/fragment/app/Fragment;", "requestCode", "jumpInviteExternalPage", "from", "isMyQrcode", "openUrl", "url", "startNewContactProfilePage", "userId", "chatApplicationId", "openInviteExternalActivityFromContact", "openCountrySelect", "activity", "Landroid/app/Activity;", "openCreateGroupChat", "convertToUserId", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomizedContactModuleDependencyImpl implements com.ss.android.lark.contact.base.dependency.a {
    public static final int $stable = 8;
    private final Lazy iMApi$delegate;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Chatter.ChatterType.values().length];
            r0[Chatter.ChatterType.USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Chatter.ChatterType.BOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Chatter.ChatterType.AI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public void openCountrySelect(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public void openCreateGroupChat(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public void openUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
    }

    private final IIMApi getIMApi() {
        return (IIMApi) this.iMApi$delegate.getValue();
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public boolean isSimpleTenant() {
        User r0 = ((b) BaseContactThirdBizService.a.getValue()).getForegroundUser();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        return !r1;
    L5:
        if (r0.getTenantTag() != 0) goto L7;
        r1 = true;
        goto L9
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public boolean isSmallB() {
        User r0 = ((b) BaseContactThirdBizService.a.getValue()).getForegroundUser();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isSmallB();
    }

    public CustomizedContactModuleDependencyImpl() {
        this.iMApi$delegate = LazyKt.lazy(CustomizedContactModuleDependencyImpl$iMApi$2.INSTANCE);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public IChatParser getChatParser() {
        return getIMApi().getChatParser();
    }

    private final String convertToUserId(Object r2) {
        if ((r2 instanceof Profile) == false) goto L6;
        String r3 = ((Profile) r2).getId();
        Intrinsics.checkNotNull(r3);
        return r3;
    L6:
        return r2.toString();
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public void jumpProfilePage(Context r12, Chatter r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "chatter");
        ContactSource.a r0 = new ContactSource.a();
        r0.b = 17;
        ContactSource r9 = new ContactSource(r0);
        Chatter.ChatterType r1 = r13.getType();
        if (r1 != null) goto L5;
        int r2 = -1;
    L7:
        if (r2 != 1) goto L9;
        com.bytedance.lark.pb.basic.v1.Chatter.Type r3 = com.bytedance.lark.pb.basic.v1.Chatter.Type.USER;
    L16:
        com.bytedance.lark.pb.basic.v1.Chatter.Type r7 = r3;
        IProfileLauncherV2.a.getClass();
        IProfileLauncherV2 r4 = IProfileLauncherV2.Companion.a();
        String r5 = r13.getId();
        Intrinsics.checkNotNull(r9);
        r4.openUserProfileV2(r12, null, r5, BuildConfig.FLAVOR, r7, BuildConfig.FLAVOR, r9, -1);
        return;
    L9:
        if (r2 != 2) goto L11;
        r3 = com.bytedance.lark.pb.basic.v1.Chatter.Type.BOT;
        goto L16
    L11:
        if (r2 == 3) goto L13;
        r3 = com.bytedance.lark.pb.basic.v1.Chatter.Type.UNKNOWN;
        goto L16
    L13:
        r3 = com.bytedance.lark.pb.basic.v1.Chatter.Type.AI;
        goto L16
    L5:
        r2 = a.a[r1.ordinal()];
        goto L7
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public void openInviteExternalActivityFromContact(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "from");
        int r0 = OfficeInviteExternalActivity.a;
        OfficeInviteExternalActivity.a.a(r2, r3);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public void jumpInviteExternalPage(Context r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "from");
        int r4 = OfficeInviteExternalActivity.a;
        OfficeInviteExternalActivity.a.a(r1, r2);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public void jumpProfilePage(Context r8, Object r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "profileObjOrId");
        jumpProfilePageForResult(r8, null, r9, r10, -1);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public void openChatFromContactHomeByChatId(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r4, "fromTag");
        ChatBundle.a r0 = new ChatBundle.a();
        r0.a = r3;
        r0.d = r4;
        r0.h = SourceType.PROFILE;
        ChatBundle r5 = new ChatBundle(r0);
        getIMApi().openChat(r2, r5);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public void startNewContactProfilePage(Context r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "userId");
        Intrinsics.checkNotNullParameter(r13, "chatApplicationId");
        ContactSource.a r14 = new ContactSource.a();
        r14.b = 18;
        ContactSource r8 = new ContactSource(r14);
        IProfileLauncherV2.a.getClass();
        IProfileLauncherV2 r1 = IProfileLauncherV2.Companion.a();
        com.bytedance.lark.pb.basic.v1.Chatter.Type r6 = com.bytedance.lark.pb.basic.v1.Chatter.Type.USER;
        Intrinsics.checkNotNull(r8);
        r1.openUserProfileV2(r11, null, r12, BuildConfig.FLAVOR, r6, BuildConfig.FLAVOR, r8, -1);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public void jumpProfilePageForResult(Context r11, Fragment r12, Object r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r13, "profileObjOrId");
        String r4 = convertToUserId(r13);
        IProfileLauncherV2.a.getClass();
        IProfileLauncherV2 r1 = IProfileLauncherV2.Companion.a();
        com.bytedance.lark.pb.basic.v1.Chatter.Type r6 = com.bytedance.lark.pb.basic.v1.Chatter.Type.USER;
        ContactSource.a r16 = new ContactSource.a();
        r16.b = r14;
        r1.openUserProfileV2(r11, r12, r4, BuildConfig.FLAVOR, r6, BuildConfig.FLAVOR, new ContactSource(r16), Integer.valueOf(r15));
    }
}
