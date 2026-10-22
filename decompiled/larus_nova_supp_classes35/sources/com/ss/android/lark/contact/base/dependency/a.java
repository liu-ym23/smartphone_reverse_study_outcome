package com.ss.android.lark.contact.base.dependency;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.chat.entity.chatter.Chatter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    IChatParser getChatParser();

    boolean isSimpleTenant();

    boolean isSmallB();

    void jumpInviteExternalPage(Context r1, String r2, boolean r3);

    void jumpProfilePage(Context r1, Chatter r2);

    void jumpProfilePage(Context r1, Object r2, int r3);

    void jumpProfilePageForResult(Context r1, Fragment r2, Object r3, int r4, int r5);

    void openChatFromContactHomeByChatId(Context r1, String r2, String r3);

    void openCountrySelect(Activity r1);

    void openCreateGroupChat(Context r1);

    void openInviteExternalActivityFromContact(Context r1, String r2);

    void openUrl(String r1);

    void startNewContactProfilePage(Context r1, String r2, String r3);
}
