package com.ss.android.lark.dto.chat;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ProfileSource {
    public final int a;
    public final int b;
    public final String c;
    public final String d;
    public final Chatter.ChatterType e;
    public final String f;
    public final boolean g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/dto/chat/ProfileSource$SourceChannel;", BuildConfig.FLAVOR, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SourceChannel {
        public static final int CHAT = 0;
        public static final a Companion = null;
        public static final int FAVORITE = 6;
        public static final int MERGE_FORWARD = 2;
        public static final int REPLY_DETAIL = 1;
        public static final int REPLY_IN_THREAD = 7;
        public static final int THREAD = 3;
        public static final int THREAD_DETAIL = 4;
        public static final int THREAD_TAB = 5;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/dto/chat/ProfileSource$SourceType;", BuildConfig.FLAVOR, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SourceType {
        public static final int AVATAR = 0;
        public static final a Companion = null;
        public static final int FORWARD_PREVIEW = 6;
        public static final int MESSAGE = 1;
        public static final int PROFILE = 3;
        public static final int REACTION = 4;
        public static final int RECALL = 5;
        public static final int SYSTEM = 2;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
        public int a;
        public int b;
        public String c;
        public String d;
        public String e;
        public final boolean f;
        public Chatter.ChatterType g;

        public final ProfileSource a() {
            return new ProfileSource(this);
        }

        public a() {
            this.a = 0;
            this.b = 1;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = false;
            this.g = null;
        }

        public a(ProfileSource r2) {
            Intrinsics.checkNotNullParameter(r2, "profileSource");
            this.a = r2.a;
            this.b = r2.b;
            this.c = r2.f;
            this.d = r2.c;
            this.e = r2.d;
            this.f = r2.g;
            this.g = r2.e;
        }
    }

    public ProfileSource(a r2) {
        this.a = r2.a;
        this.b = r2.b;
        this.c = r2.d;
        this.d = r2.e;
        this.e = r2.g;
        this.f = r2.c;
        this.g = r2.f;
    }
}
