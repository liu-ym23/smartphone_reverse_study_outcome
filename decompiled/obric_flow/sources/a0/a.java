package a0;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f34c = null;
    public static final String[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f35a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContentResolver f36b;

    static {
        f34c = new String[]{"_data"};
        d = new String[]{"_data"};
    }

    public /* synthetic */ a(ContentResolver r5, int r10) {
        this.f35a = r10;
        this.f36b = r5;
    }

    @Override // a0.c
    public final Cursor a(Uri r10) {
        switch(this.f35a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        String r11 = r10.getLastPathSegment();
        ContentResolver r5 = this.f36b;
        return r5.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, d, "kind = 1 AND video_id = ?", new String[]{r11}, null);
    L6:
        String r12 = r10.getLastPathSegment();
        ContentResolver r13 = this.f36b;
        return r13.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f34c, "kind = 1 AND image_id = ?", new String[]{r12}, null);
    }
}
