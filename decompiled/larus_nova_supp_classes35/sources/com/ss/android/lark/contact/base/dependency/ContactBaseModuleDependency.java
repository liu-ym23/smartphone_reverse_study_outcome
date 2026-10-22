package com.ss.android.lark.contact.base.dependency;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.base.service.z;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ContactBaseModuleDependency implements a {
    public static final ContactBaseModuleDependency b = null;
    public static final Lazy c = null;
    public final /* synthetic */ a a;

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final IChatParser getChatParser() {
        return this.a.getChatParser();
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final boolean isSimpleTenant() {
        return this.a.isSimpleTenant();
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final boolean isSmallB() {
        return this.a.isSmallB();
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void jumpInviteExternalPage(Context r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter("contact_external", "from");
        this.a.jumpInviteExternalPage(r2, "contact_external", false);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void jumpProfilePage(Context r2, Chatter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatter");
        this.a.jumpProfilePage(r2, r3);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void jumpProfilePage(Context r2, Object r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "profileObjOrId");
        this.a.jumpProfilePage(r2, r3, r4);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void jumpProfilePageForResult(Context r7, Fragment r8, Object r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r9, "profileObjOrId");
        this.a.jumpProfilePageForResult(r7, r8, r9, r10, 273);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void openChatFromContactHomeByChatId(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r4, "fromTag");
        this.a.openChatFromContactHomeByChatId(r2, r3, r4);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void openCountrySelect(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a.openCountrySelect(r2);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void openCreateGroupChat(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a.openCreateGroupChat(r2);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void openInviteExternalActivityFromContact(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter("contact_new", "from");
        this.a.openInviteExternalActivityFromContact(r2, "contact_new");
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void openUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.a.openUrl(r2);
    }

    @Override // com.ss.android.lark.contact.base.dependency.a
    public final void startNewContactProfilePage(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "chatApplicationId");
        this.a.startNewContactProfilePage(r2, r3, r4);
    }

    static {
        b = new ContactBaseModuleDependency();
        c = LazyKt.lazy(ContactBaseModuleDependency$defaultOfficeContactRepository$2.INSTANCE);
    }

    public static z a() {
        return (z) c.getValue();
    }

    public ContactBaseModuleDependency() {
        this.a = (a) ApiUtils.getApi(a.class);
    }
}
