package com.bumptech.glide.load.data;

import ai.j0;
import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class n extends b {
    public static final UriMatcher e = null;

    static {
        UriMatcher r5 = new UriMatcher(-1);
        e = r5;
        r5.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        r5.addURI("com.android.contacts", "contacts/lookup/*", 1);
        r5.addURI("com.android.contacts", "contacts/#/photo", 2);
        r5.addURI("com.android.contacts", "contacts/#", 3);
        r5.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        r5.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class c() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.b
    public final void g(Object r5) {
        ((InputStream) r5).close();
    }

    @Override // com.bumptech.glide.load.data.b
    public final Object h(ContentResolver r5, Uri r10) {
        int r11 = e.match(r10);
        if (r11 != 1) goto L5;
    L10:
        Uri r12 = ContactsContract.Contacts.lookupContact(r5, r10);
        if (r12 == null) goto L18;
        InputStream r13 = ContactsContract.Contacts.openContactPhotoInputStream(r5, r12, true);
    L13:
        if (r13 == null) goto L16;
        return r13;
    L16:
        throw new FileNotFoundException(j0.i(r10, "InputStream is null for "));
    L18:
        throw new FileNotFoundException("Contact cannot be found");
    L5:
        if (r11 != 3) goto L7;
        r13 = ContactsContract.Contacts.openContactPhotoInputStream(r5, r10, true);
        goto L13
    L7:
        if (r11 == 5) goto L10;
        r13 = r5.openInputStream(r10);
        goto L13
    }
}
