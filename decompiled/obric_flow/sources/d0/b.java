package d0;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class b implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f16527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f16528c;

    public b(Resources r5, r r10) {
        this.f16526a = 1;
        this.f16528c = r5;
        this.f16527b = r10;
    }

    @Override // d0.r
    public final boolean a(Object r5) {
        switch(this.f16526a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Integer r10 = (Integer) r5;
        return true;
    L6:
        Uri r11 = (Uri) r5;
        if ("file".equals(r11.getScheme()) == true) goto L9;
        return false;
    L9:
        if (r11.getPathSegments().isEmpty() == false) goto L11;
        return false;
    L11:
        if ("android_asset".equals(r11.getPathSegments().get(0)) == false) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // d0.r
    public final q b(Object r10, int r11, int r12, z.f r13) {
        switch(this.f16526a) {
            case 0: goto L16;
            default: goto L4;
        };
    L4:
        Integer r14 = (Integer) r10;
        Resources r5 = (Resources) this.f16528c;
        Uri r15 = Uri.parse("android.resource://" + r5.getResourcePackageName(r14.intValue()) + '/' + r5.getResourceTypeName(r14.intValue()) + '/' + r5.getResourceEntryName(r14.intValue()));     // Catch: Resources.NotFoundException -> L7
    L12:
        if (r15 != null) goto L15;
        return null;
    L15:
        return ((r) this.f16527b).b(r15, r11, r12, r13);
    L7:
        e = move-exception;
        if (Log.isLoggable("ResourceLoader", 5) == false) goto L11;
        Log.w("ResourceLoader", "Received invalid resource id: " + r14, e);
    L11:
        r15 = null;
        goto L12
    L16:
        Uri r16 = (Uri) r10;
        String r17 = r16.toString().substring(22);
        p0.b r18 = new p0.b(r16);
        Object r19 = this.f16528c;
        AssetManager r20 = (AssetManager) this.f16527b;
        switch(((a) r19).f16522a) {
            case 0: goto L19;
            default: goto L18;
        };
    L18:
        com.bumptech.glide.load.data.k r21 = new com.bumptech.glide.load.data.k(r20, r17, 1);
    L21:
        return new q(r18, r21);
    L19:
        r21 = new com.bumptech.glide.load.data.k(r20, r17, 0);
        goto L21
    }

    public b(AssetManager r5, a r10) {
        this.f16526a = 0;
        this.f16527b = r5;
        this.f16528c = r10;
    }
}
