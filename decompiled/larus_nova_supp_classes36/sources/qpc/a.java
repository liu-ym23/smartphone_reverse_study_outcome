package qpc;

import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.bytedance.lark.pb.basic.v1.SerCrypto;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {
    Resource getAvatarImageResource(long r1, String r3, int r4, float r5, String r6, String r7);

    String getEmojiImage(String r1, String r2);

    Resource getEncryptImage(String r1, String r2, String r3, ByteString r4, String r5, boolean r6);

    Resource getEncryptImage(String r1, String r2, String r3, ByteString r4, String r5, boolean r6, int r7);

    Resource getPassThroughImage(String r1, String r2, String r3, SerCrypto r4, ImageSetPassThrough.FileType r5);

    String getReactionImage(String r1, String r2);
}
