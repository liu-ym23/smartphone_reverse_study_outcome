package com.ss.android.lark.coremdbiz.facade.link;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/coremdbiz/facade/link/LinkType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "UrlInline", "CustomLink", "PossibleLink", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LinkType extends Enum<LinkType> {
    public static final LinkType CustomLink = null;
    public static final LinkType PossibleLink = null;
    public static final LinkType UrlInline = null;
    public static final /* synthetic */ LinkType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LinkType> getEntries() {
        return b;
    }

    static {
        LinkType r0 = new LinkType("UrlInline", 0);
        UrlInline = r0;
        LinkType r1 = new LinkType("CustomLink", 1);
        CustomLink = r1;
        LinkType r3 = new LinkType("PossibleLink", 2);
        PossibleLink = r3;
        LinkType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static LinkType[] values() {
        return (LinkType[]) a.clone();
    }

    public static LinkType valueOf(String r1) {
        return (LinkType) a.a(LinkType.class, r1);
    }

    public LinkType(String r1, int r2) {
        super(r1, r2);
    }
}
