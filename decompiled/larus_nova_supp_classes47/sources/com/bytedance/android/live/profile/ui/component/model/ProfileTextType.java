package com.bytedance.android.live.profile.ui.component.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/model/ProfileTextType;", "", "Companion", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ProfileTextType {
    public static final int Announce = 6;
    public static final a Companion = null;
    public static final int Follow = 0;
    public static final int PlayTime = 3;
    public static final int Push = 7;
    public static final int Signature = 2;
    public static final int SignatureLongText = 4;
    public static final int SpreadIcon = 5;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }
}
