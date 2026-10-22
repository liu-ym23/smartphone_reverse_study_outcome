package com.ss.android.lark.export.params;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import vcb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class URLPreviewParams {
    public final String a;
    public final boolean b;
    public final String c;
    public final boolean d;
    public final Map<String, Object> e;
    public final String f;
    public final String g;
    public final Long h;
    public final Long i;
    public final Boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/export/params/URLPreviewParams$SourceType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MyAIDialog", "Chat", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SourceType extends Enum<SourceType> {
        public static final SourceType Chat = null;
        public static final a Companion = null;
        public static final SourceType MyAIDialog = null;
        public static final /* synthetic */ SourceType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<SourceType> getEntries() {
            return b;
        }

        static {
            SourceType r0 = new SourceType("MyAIDialog", 0, 0);
            MyAIDialog = r0;
            SourceType r1 = new SourceType("Chat", 1, 1);
            Chat = r1;
            SourceType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static SourceType[] values() {
            return (SourceType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SourceType valueOf(String r1) {
            return (SourceType) r27.a.a(SourceType.class, r1);
        }

        public SourceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public String a;
        public boolean b;
        public String c;
        public boolean d;
        public Map<String, ? extends Object> e;
        public String f;
        public String g;
        public String h;
        public Long i;
        public Long j;
        public Boolean k;
        public boolean l;
        public b m;
        public boolean n;
        public boolean o;

        public a() {
            this.a = BuildConfig.FLAVOR;
            this.d = true;
            this.e = new LinkedHashMap();
            this.g = BuildConfig.FLAVOR;
            this.h = BuildConfig.FLAVOR;
            this.i = 0L;
            this.j = 0L;
            this.k = Boolean.FALSE;
            SourceType.a r0 = SourceType.Companion;
        }
    }

    public URLPreviewParams(a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.a = r2.a;
        this.b = r2.b;
        this.c = r2.c;
        this.d = r2.d;
        this.e = r2.e;
        this.f = r2.f;
        String r0 = r2.g;
        this.g = r2.h;
        this.h = r2.i;
        this.i = r2.j;
        this.j = r2.k;
        this.k = r2.l;
        b r1 = r2.m;
        this.l = r2.o;
        this.m = r2.n;
    }
}
