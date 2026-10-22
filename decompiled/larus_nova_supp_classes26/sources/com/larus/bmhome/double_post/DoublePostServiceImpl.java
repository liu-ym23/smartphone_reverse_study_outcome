package com.larus.bmhome.double_post;

import com.larus.bmhome.double_post.fragment.AwemeDoublePostFragment;
import com.larus.bmhome.video.IAwemeDoublePostService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/double_post/DoublePostServiceImpl;", "Lcom/larus/bmhome/video/IAwemeDoublePostService;", "<init>", "()V", "getDoublePostFragment", "Lcom/larus/bmhome/video/IAwemeDoublePostFragment;", "getDoublePostTrackManager", "Lcom/larus/bmhome/video/IAwemeDoublePostTrackManager;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoublePostServiceImpl implements IAwemeDoublePostService {
    public DoublePostServiceImpl() {
    }

    @Override // com.larus.bmhome.video.IAwemeDoublePostService
    public final AwemeDoublePostFragment a() {
        return new AwemeDoublePostFragment();
    }

    @Override // com.larus.bmhome.video.IAwemeDoublePostService
    public final void b() {
        com.larus.bmhome.double_post.utils.e r0 = com.larus.bmhome.double_post.utils.e.a;
    }
}
