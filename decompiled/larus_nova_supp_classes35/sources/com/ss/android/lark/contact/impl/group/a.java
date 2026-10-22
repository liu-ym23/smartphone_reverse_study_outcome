package com.ss.android.lark.contact.impl.group;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.entity.SelectedData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements LifecycleObserver {
    public final /* synthetic */ ContactsMyGroupFragment.b a;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        ContactsMyGroupFragment.b r0 = this.a;
        Message r1 = r0.a;
        Chat r2 = r0.b;
        Message r3 = Message.obtain();
        if (r2 == null) goto L8;
        Bundle r4 = new Bundle();
        r3.setData(r4);
        SelectedData r5 = new SelectedData();
        r5.dataType = SelectedData.DataType.CHAT;
        r5.id = r2.getId();
        r5.name = r2.getName();
        r5.avatarKey = r2.getAvatarKey();
        r5.addToBundle(r4);
    L8:
        r1.replyTo.send(r3);     // Catch: RemoteException -> L7
        return;
    }

    public a(ContactsMyGroupFragment.b r1) {
        this.a = r1;
    }
}
