package bq8;

import kotlin.jvm.internal.Intrinsics;
import luc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements juc.d<a> {
    public static final b a = null;
    public static final f b = null;

    public b() {
    }

    static {
        a = new b();
        b = c.Companion.serializer().getDescriptor();
    }

    public final f getDescriptor() {
        return b;
    }

    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return new a((c) c.Companion.serializer().deserialize(r2));
    }

    public final void serialize(muc.f r29, Object r30) {
        a r1 = (a) r30;
        Intrinsics.checkNotNullParameter(r29, "encoder");
        Intrinsics.checkNotNullParameter(r1, "value");
        juc.d<c> r2 = c.Companion.serializer();
        r1.getClass();
        r2.serialize(r29, new c(r1.getVid(), r1.getVideoModel(), r1.getShareInfo(), r1.getCreator(), r1.getLyrics(), r1.getLyricsSeekContent(), r1.getTitle(), Boolean.valueOf(r1.getTitleEdited()), r1.getCover(), Boolean.valueOf(r1.getCoverEdited()), r1.getCoverMainColor(), Boolean.valueOf(r1.getMusicGenFailed()), r1.getMusicGenFailedMsg(), r1.getChunkUrl(), Integer.valueOf(r1.getMusicGenType()), r1.getUseTemplateId(), r1.getUniqueTaskId(), Boolean.valueOf(r1.isBlock()), Long.valueOf(r1.a), r1.b, Long.valueOf(r1.c), r1.d));
    }
}
