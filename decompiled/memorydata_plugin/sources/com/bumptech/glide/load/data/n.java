package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class n extends l<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final UriMatcher f695a = null;

    static {
        UriMatcher r0 = new UriMatcher(-1);
        f695a = r0;
        r0.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        r0.addURI("com.android.contacts", "contacts/lookup/*", 1);
        r0.addURI("com.android.contacts", "contacts/#/photo", 2);
        r0.addURI("com.android.contacts", "contacts/#", 3);
        r0.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        r0.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public n(ContentResolver r1, Uri r2) {
        super(r1, r2);
    }

    private InputStream a(ContentResolver r1, Uri r2) {
        return ContactsContract.Contacts.openContactPhotoInputStream(r1, r2, true);
    }

    private InputStream c(Uri r3, ContentResolver r4) {
        int r0 = f695a.match(r3);
        if (r0 != 1) goto L5;
    L12:
        Uri r5 = ContactsContract.Contacts.lookupContact(r4, r3);
        if (r5 == null) goto L17;
        return a(r4, r5);
    L17:
        throw new FileNotFoundException("Contact cannot be found");
    L5:
        if (r0 == 3) goto L11;
        if (r0 == 5) goto L12;
        return r4.openInputStream(r3);
    L11:
        return a(r4, r3);
    }

    public InputStream a(Uri r2, ContentResolver r3) {
        InputStream r1 = c(r2, r3);
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new FileNotFoundException("InputStream is null for " + r2);
    }

    @Override // com.bumptech.glide.load.data.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(InputStream r1) {
        r1.close();
    }

    @Override // com.bumptech.glide.load.data.l
    public /* synthetic */ void a(InputStream r3) {
        a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bumptech.glide.load.data.l
    public /* synthetic */ InputStream b(Uri r1, ContentResolver r2) {
        return a(r1, r2);
    }
}
