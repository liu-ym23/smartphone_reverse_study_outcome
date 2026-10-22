package com.larus.bmhome.social.userchat.messagelist.model;

import android.util.LruCache;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \b*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\bJ \u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/social/userchat/messagelist/model/IMessageContentConvertor;", "CONTENT", "", "convert", "Lkotlin/Pair;", "", "message", "Lcom/larus/im/bean/message/Message;", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMessageContentConvertor<CONTENT> {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final LruCache<String, Object> b = null;

        public a() {
        }

        static {
            a = new a();
            b = new LruCache(100);
        }
    }

    static {
        a = a.a;
    }

    Pair<Boolean, CONTENT> a(Message r1);
}
