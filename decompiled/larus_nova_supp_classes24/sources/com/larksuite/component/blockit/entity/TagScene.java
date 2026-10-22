package com.larksuite.component.blockit.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum TagScene extends Enum<TagScene> {
    public static final TagScene Default = null;
    public static final TagScene PrivateCollection = null;
    public static final TagScene PublicTopic = null;
    public static final TagScene TeamKnowledge = null;
    public static final TagScene Teamwork = null;
    public static final /* synthetic */ TagScene[] a = null;
    int value;

    static {
        TagScene r0 = new TagScene("Default", 0, 0);
        Default = r0;
        TagScene r1 = new TagScene("Teamwork", 1, 1);
        Teamwork = r1;
        TagScene r3 = new TagScene("TeamKnowledge", 2, 2);
        TeamKnowledge = r3;
        TagScene r5 = new TagScene("PrivateCollection", 3, 3);
        PrivateCollection = r5;
        TagScene r7 = new TagScene("PublicTopic", 4, 4);
        PublicTopic = r7;
        a = new TagScene[]{r0, r1, r3, r5, r7};
    }

    public static TagScene[] values() {
        return (TagScene[]) a.clone();
    }

    public int value() {
        return this.value;
    }

    public static TagScene valueOf(String r1) {
        return (TagScene) r27.a.a(TagScene.class, r1);
    }

    public TagScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
