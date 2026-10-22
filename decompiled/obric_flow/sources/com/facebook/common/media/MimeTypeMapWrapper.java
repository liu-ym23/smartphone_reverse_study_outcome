package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MimeTypeMapWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MimeTypeMap f7660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f7661b = null;

    static {
        f7660a = MimeTypeMap.getSingleton();
        ImmutableMap.a("image/heif", "heif", "image/heic", "heic");
        f7661b = ImmutableMap.a("heif", "image/heif", "heic", "image/heic");
    }
}
